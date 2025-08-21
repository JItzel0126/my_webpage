package com.mywebpage.mywebpage.novel.episode.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpisodeDto {

    private Long id;
    private int epiNumber;
    private int price;
    private String epiTitle;
    private String content;
    private Long seriesId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
