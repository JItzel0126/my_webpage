package com.mywebpage.mywebpage.user.service;

import com.mywebpage.mywebpage.common.CommonException;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.user.dto.UserRequestDto;
import com.mywebpage.mywebpage.user.dto.UserResponseDto;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    // email로 유저 엔티티 조회(없으면 예외처리)
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(errorMsg.getMessage("errors.not.found")));
    }

    // email로 유저 Dto 조회 (뷰/응답용)
    public UserResponseDto getDtoByEmail(String email) {
        User user = getByEmail(email);
        return mapStruct.toResponseDto(user);
    }

}
