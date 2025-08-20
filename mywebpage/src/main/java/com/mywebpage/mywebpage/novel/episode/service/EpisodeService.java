package com.mywebpage.mywebpage.novel.episode.service;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.episode.repository.EpisodeRepository;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final SeriesRepository seriesRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;
}
