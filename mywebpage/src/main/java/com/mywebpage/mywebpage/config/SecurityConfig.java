package com.mywebpage.mywebpage.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// DispatcherType 종류 :
//      REQUEST: 클라이언트가 보낸 일반 요청
//      FORWARD: 서버 내부에서 forward한 요청 (ex: JSP/Thymeleaf 뷰 이동)
//      INCLUDE: 다른 서블릿 include 할 때 (JSP include)
//      ERROR: 에러 페이지로 forward할 때
//      ASYNC: 비동기 디스패처

// hasAuthority("ROLE_ADMIN") :
//      인자로 들어가는 문자열이 GrantedAuthority 그대로 매칭
// hasRole("ADMIN") :
//      내부적으로 자동으로 `"ROLE_" prefix를 붙여서 검사 : ("ADMIN") = ("ROLE_ADMIN")
// hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_SUPER")
//      사용자가 여러 권한 중 하나라도 가지고 있으면 통과(or 조건)

// .loginProcessingUrl() : 로그인 폼에서 입력한 아이디/비밀번호를 실제로 처리할 url
//  1. 임의로 지정 가능, 2. 지정 안할 시 기본값 loginPage와 같음
//  form 의 action 값과 동일해야함

//  .usernameParameter("email") :
//  폼 필드 이름은 기본값이 username, password,
//  현재 email로 로그인을 설정해놨기 때문에 지정해주어야 함

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
// dispatcherTypeMatchers(DispatcherType.FORWARD) → 서블릿 DispatcherType이 FORWARD인 요청을 잡아서 권한을 설정
// TODO: DispatcherType.FORWARD : 컨트롤러나 뷰 리졸버가 내부적으로 다른 리소스로 froward 시키는 요청
//  예) return "home"; 시 home.html로 forward 됨(뷰 렌더링 허용)
// TODO: .anyRequest().authenticated() : 위에서 따로 허용한 URL 제외 나머지 요청은 모두 로그인해야 접근 가능

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/login","/signup","/","/errors").permitAll() // 로그인 회원가입 페이지는 누구나 접근
                .requestMatchers("/css/**", "/images/**", "/js/**").permitAll() // 정적 리소스 파일 누구나 접근
                .requestMatchers("/h2-console/**").permitAll()   // ✅ H2 콘솔 허용
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
        )
        .formLogin(login->login
                .loginPage("/login")
                .loginProcessingUrl("/processLogin")
                .usernameParameter("email")
                .defaultSuccessUrl("/", true)   // 로그인 성공시 갈 페이지
                .failureUrl("/login?error=true")
                .permitAll()
        )
        .logout(logout->logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
        );

//        h2 콘솔용
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
        http.headers(headers -> headers.frameOptions().sameOrigin());
        return http.build();
    }
}
