package com.mywebpage.mywebpage.comment.boardcomment.dto;



import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BcommentDto {

    private Long bcno;
    private String content;
//    writer.getName()
    private String writer;
//    parent가 있으면 부모 기본키 가져오기, parent.bcno
    private Long parentBcno;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    대댓글 카운트
    private int replyCount;
}
