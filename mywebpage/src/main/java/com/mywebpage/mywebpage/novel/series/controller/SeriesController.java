package com.mywebpage.mywebpage.novel.series.controller;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.episode.dto.EpisodeDto;
import com.mywebpage.mywebpage.novel.episode.repository.EpisodeRepository;
import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import com.mywebpage.mywebpage.novel.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;
    private final SeriesRepository seriesRepository;
    private final EpisodeRepository episodeRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    전체조회(페이징)
//    @GetMapping("/mwp")
//    public String searchAllSeries(@RequestParam(defaultValue = "")String keyword,
//                                  @PageableDefault(page = 0, size = 5) Pageable pageable,
//                                  Model model) {
//        Page<SeriesDto> dtos = seriesService.searchAll(pageable, keyword);
//        log.info(dtos.getContent());
//        model.addAttribute("series", dtos.getContent());
//        model.addAttribute("page", dtos);
//        return "mwp/series_all";
//    }

//    전체조회(list-main)
    @GetMapping("/")
    public String findAllSeries(Model model) {
        List<SeriesDto> allSeries = seriesService.findRecentSeries(10);
        List<SeriesDto> fantasySeries = seriesService.findRecentSeriesByGenre("판타지", 10);
        List<SeriesDto> romanceSeries = seriesService.findRecentSeriesByGenre("로맨스", 10);
        model.addAttribute("all", allSeries);
        model.addAttribute("fantasy", fantasySeries);
        model.addAttribute("romance", romanceSeries);
        return "home";
    }

//    서치바
    @GetMapping("/search")
    public String searchAll(@RequestParam(defaultValue = "") String keyword,
                            @PageableDefault(size = 3) Pageable pageable,
                            Model model) {

        Page<SeriesDto> result = seriesService.searchAll(pageable, keyword);

        model.addAttribute("result", result.getContent());
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", result);
        return "views/novel/search";
    }


//    Map 사용
//    @GetMapping("/")
//        public String findGenreSeries(Model model) {
//        Map<String, List<SeriesDto>> genreMap = new HashMap<>();
//        genreMap.put("fantasy", seriesService.findRecentSeriesByGenre("판타지", 10));
//        genreMap.put("romance", seriesService.findRecentSeriesByGenre("로맨스",10));
//        model.addAttribute("genreMap", genreMap);
//        return "home";
//    }

//    상세조회
    @GetMapping("/series/{id}")
    public String getSeries(@PathVariable Long id,
                            @RequestParam(defaultValue = "desc") String sort,
                            Model model) {
//        시리즈 상세조회
        SeriesDto series = seriesService.findById(id, sort);

        model.addAttribute("series", series);
        model.addAttribute("sort", sort);

        return "views/novel/series";
    }



}
