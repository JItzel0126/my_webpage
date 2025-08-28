package com.mywebpage.mywebpage.comment.novelcomment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NcommentDto {

    private Long ncno;
    private String content;
//    series_id (매퍼로 연결 명시 필요함)
    private Long id;
//    user_name
    private String writer;
    private LocalDateTime cratedAt;
    private LocalDateTime updatedAt;
}
