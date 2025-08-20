package com.mywebpage.mywebpage.novel.episode.controller;

import com.mywebpage.mywebpage.novel.episode.service.EpisodeService;
import com.mywebpage.mywebpage.novel.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class EpisodeController {
    private final SeriesService seriesService;
    private final EpisodeService episodeService;
}
