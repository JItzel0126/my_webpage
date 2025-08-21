package com.mywebpage.mywebpage.novel.series.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesDto {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String fileName;
    private String fileUrl;
    private String genre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastEpisodeUpdatedAt;
}
