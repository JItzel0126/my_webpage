// Episode.java

package com.mywebpage.mywebpage.novel.episode.entity;

import com.mywebpage.mywebpage.common.BaseTimeEntity;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper=false)
@Table(name = "episode")
@Entity
@Builder
public class Episode extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int epiNumber;
    private int price;

    @Column(length = 200)
    private String epiTitle;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

}
