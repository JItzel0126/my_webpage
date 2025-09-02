package com.mywebpage.mywebpage.novel.episode.controller;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import com.mywebpage.mywebpage.novel.episode.entity.Episode;
import com.mywebpage.mywebpage.novel.episode.service.EpisodeService;
import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import com.mywebpage.mywebpage.novel.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class EpisodeController {
    private final SeriesService seriesService;
    private final EpisodeService episodeService;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    상세조회
    @GetMapping("/episode/{id}")
    public String episode(@PathVariable Long id,
                          Model model) {
//        에피소드 상세조회
        EpisodeDto episodeDto = episodeService.getById(id);
        SeriesDto seriesDto = seriesService.findById(episodeDto.getSeriesId(),"asc");

//        이전 / 다음
        List<EpisodeDto> episode = seriesDto.getEpisode();
        EpisodeDto prevEpisode = episode.stream()
                        .filter(ep->ep.getEpiNumber() == episodeDto.getEpiNumber() -1)
                                .findFirst().orElse(null);
        EpisodeDto nextEpisode = episode.stream()
                        .filter(ep->ep.getEpiNumber() == episodeDto.getEpiNumber()+1)
                                .findFirst().orElse(null);

        model.addAttribute("series", seriesDto);
        model.addAttribute("episode", episodeDto);
        model.addAttribute("prev", prevEpisode);
        model.addAttribute("next", nextEpisode);

        return "views/novel/episode";
    }
}
