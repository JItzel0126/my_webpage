package com.mywebpage.mywebpage.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 12, nullable = false)
    private String password;
    @Column(unique = true, length = 50)
    private String email;
    @Column(nullable = false)
    private String role="ROLE_USER"; // 기본 USER, 관리자 ROLE_ADMIN

}
