package com.mywebpage.mywebpage.novel.episode.service;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import com.mywebpage.mywebpage.novel.episode.entity.Episode;
import com.mywebpage.mywebpage.novel.episode.repository.EpisodeRepository;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final SeriesRepository seriesRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    전체조회
    public Page<EpisodeDto> getAll(Pageable pageable) {
        Page<Episode> episodes = episodeRepository.findAll(pageable);
        return episodes.map(data->mapStruct.toDto(data));
    }

//    추가
    public void save(EpisodeDto dto) {
        Episode episode = mapStruct.toEntity(dto);
        Series series = seriesRepository.findById(dto.getSeriesId())
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        episode.setSeries(series);
        episodeRepository.save(episode);
    }

//    update(dirty 체킹)
    @Transactional
    public void update(EpisodeDto dto) {
        Episode episode = episodeRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        mapStruct.update(dto, episode);
    }

//    삭제
    public void delete(long id) {
        episodeRepository.deleteById(id);
    }
}
