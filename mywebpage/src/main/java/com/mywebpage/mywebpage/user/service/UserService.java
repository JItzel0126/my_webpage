package com.mywebpage.mywebpage.user.service;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.user.dto.UserRequestDto;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    회원가입
    public void register(UserRequestDto userDto) {
//        이메일 중복 체크
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException(errorMsg.getMessage("errors.duplicateEmail"));
        }
//        닉네임 중복 체크
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException(errorMsg.getMessage("errors.duplicateName"));
        }
//        비밀번호 인코딩
        String password = passwordEncoder.encode(userDto.getPassword());
//        DTO -> Entity 변환
        User user = mapStruct.toRequestEntity(userDto);
//      TODO: 엔티티에만 암호화 한 비밀번호와 권한 주입
        user.setPassword(password);
        user.setRole("ROLE_USER");
//        저장
        userRepository.save(user);
    }

}
