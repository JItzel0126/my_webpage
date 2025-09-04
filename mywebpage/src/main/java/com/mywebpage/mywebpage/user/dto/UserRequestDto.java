package com.mywebpage.mywebpage.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    private String email;
    private String name;
    private String password;
}
