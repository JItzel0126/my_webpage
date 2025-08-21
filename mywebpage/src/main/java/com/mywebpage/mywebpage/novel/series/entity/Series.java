// Series.java

package com.mywebpage.mywebpage.novel.series.entity;

import com.mywebpage.mywebpage.common.BaseTimeEntity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper=false)
@Table(name = "series")
@Entity
@Builder
public class Series extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(length = 100)
    private String author;
    @Column(length = 200)
    private String publisher;
    @Column(length = 1000)
    private String description;
//    사용자가 업로드한 실제 파일명
    @Column(length = 200)
    private String fileName;
//    서버 접근 url
    @Column(length = 500)
    private String fileUrl;
    @Column(length = 20)
    private String genre;
    // 에피소드가 추가되거나 수정될 때 갱신되는 필드
    private LocalDateTime lastEpisodeUpdatedAt;

}
