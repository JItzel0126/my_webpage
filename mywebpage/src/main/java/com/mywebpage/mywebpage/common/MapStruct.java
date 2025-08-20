package com.mywebpage.mywebpage.common;

import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import com.mywebpage.mywebpage.novel.episode.entity.Episode;
import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// 스프링과 연결
// null 제외 기능(update 시 사용)
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MapStruct {

//    Series
    Series toEntity(SeriesDto seriesDto);
    SeriesDto toDto(Series series);
//    dirty 체킹
    void update(SeriesDto seriesDto, @MappingTarget Series series);

//    Episode
    @Mapping(source = "seriesId", target = "series.id")
    Episode toEntity(EpisodeDto episodeDto);
    @Mapping(source = "series.id", target = "seriesId")
    EpisodeDto toDto(Episode episode);
//    dirty 체킹
    void update(EpisodeDto episodeDto, @MappingTarget Episode episode);
}
