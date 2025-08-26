package com.mywebpage.mywebpage.common;

import com.mywebpage.mywebpage.comment.boardcomment.dto.BcommentDto;
import com.mywebpage.mywebpage.comment.boardcomment.entity.Bcomment;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import com.mywebpage.mywebpage.novel.episode.entity.Episode;
import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.user.dto.UserDto;
import com.mywebpage.mywebpage.user.entity.User;
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


//    user

    User toEntity(UserDto userDto);
    UserDto toDto(User user);

//    board
    @Mapping(source = "writer", target = "writer.name")
//    "DTO.writer(String)을 Board.writer(User)의 name 필드에 집어넣어라"
    Board toEntity(BoardDto boardDto);
    @Mapping(source = "writer.name", target = "writer")
    BoardDto toDto(Board board);
//    더티체킹

    @Mapping(ignore = true, target = "writer")
    @Mapping(ignore = true, target = "bno")
    @Mapping(ignore = true, target = "likeCount")
    @Mapping(ignore = true, target = "viewCount")
    @Mapping(ignore = true, target = "commentCount")
    void update(BoardDto boardDto, @MappingTarget Board board);

//    bcomment
//  @Mapping(sorce="", target="객체.참조객체의 필드")
    @Mapping(source = "writer", target = "writer.name")
    @Mapping(source = "parentBcno", target = "parent.bcno")
    Bcomment toEntity(BcommentDto bcommentDto);
//   parent 객체의 id → DTO.parentBcno
    @Mapping(source = "writer.name", target = "writer")
    @Mapping(source = "parent.bcno", target = "parentBcno")
    BcommentDto toDto(Bcomment bcomment);
}
