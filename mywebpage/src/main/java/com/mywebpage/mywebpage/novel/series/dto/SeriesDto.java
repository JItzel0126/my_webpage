package com.mywebpage.mywebpage.novel.series.dto;

import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
//  시리즈 상세에서 에피소드 리스트 불러오기
    private List<EpisodeDto> episode;
}
