package com.mywebpage.mywebpage.user.service;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.user.dto.SecurityUserDto;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// TODO: UserDetailsService 인터페이스 :
//      Spring Security에서 로그인 시 반드시 호출하는 컴포넌트

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
//    DB User 레포지토리 Di
    private final UserRepository userRepository;
    private final ErrorMsg errorMsg;

//    오버라이드 (함수 재정의)
// TODO: loadUserByUsername(String username):
//    DB에서 유저를 찾고, UserDetails 객체(SecurityUserDto)를 반환

    @Override
    public UserDetails loadUserByUsername(String username) {
//  TODO: 1)유저 찾기 (DB 조회 - findByEmail(username)
        User users = userRepository.findByEmail(username)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.register")));

//  TODO: 2) 권한 부여
//   없으면 검증 객체에 정보 넣기
        GrantedAuthority authority = new SimpleGrantedAuthority(users.getRole());
//  TODO: 권한 배열 Set에 넣기
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(authority);
//  TODO: SecurityUserDto로 감싸서 반환
//   생성자 email, password, 권한배열
        return new SecurityUserDto(users.getEmail(),
                                users.getPassword(),
                                grantedAuthorities);
    }
}
