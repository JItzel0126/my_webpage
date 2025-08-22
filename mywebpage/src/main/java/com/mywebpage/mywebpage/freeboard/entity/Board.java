package com.mywebpage.mywebpage.freeboard.entity;

import com.mywebpage.mywebpage.common.BaseTimeEntity;
import com.mywebpage.mywebpage.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "freeboard")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="bno", callSuper = false)
@Builder
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private int likeCount=0;
    private int viewCount=0;
    private int commentCount=0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uno", nullable = false)
    private User writer;
}
