package com.mywebpage.mywebpage.user.entity;

import jakarta.persistence.*;
import lombok.*;

// user는 예약어라 테이블명에 's'붙임

@Entity
@Table(name = "users")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="uno", callSuper = false)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uno;
//    실명 대신 사용할 이름
    @Column(unique = true, length = 50, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(unique = true, length = 50)
    private String email;

//  TODO: columnDefinition = "varchar(20) default 'ROLE_USER'"
//        (기본값 저장) : 기본 USER, 관리자 ROLE_ADMIN (서비스 로직에서)
    @Column(nullable = false)
    private String role;

}
