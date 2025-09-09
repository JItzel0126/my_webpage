package com.mywebpage.mywebpage.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class SecurityUserDto extends User {

//    로그인 유저를 불러왔을 때 name 대신 email이 나타나는 문제 해결을 위해
    private Long id;        // 추가 id
    private String name;    // 추가 name

//    편의 생성자: email/password/권한만 받는 기존 코드와 호환
    public SecurityUserDto(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.id = null;
        this.name = null;
    }

//    public SecurityUserDto(Long id, String name, String email, String password,
//                           Collection<? extends GrantedAuthority> authorities) {
//        super(password, email, authorities);
//        this.id = id;
//        this.name = name;
//    }

}
