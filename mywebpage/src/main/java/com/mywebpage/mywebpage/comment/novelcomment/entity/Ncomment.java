package com.mywebpage.mywebpage.comment.novelcomment.entity;

import com.mywebpage.mywebpage.common.BaseTimeEntity;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "novel_comment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Ncomment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ncno;
    @Column(length = 500)
    private String content;

//    댓글이 달리는 시리즈
//    단방향 조회
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", referencedColumnName = "name", nullable = false)
    private User writer;

}
