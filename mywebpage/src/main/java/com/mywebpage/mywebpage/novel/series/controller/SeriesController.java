package com.mywebpage.mywebpage.novel.series.controller;

import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.novel.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;

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

//    Map 사용
//    @GetMapping("/")
//        public String findGenreSeries(Model model) {
//        Map<String, List<SeriesDto>> genreMap = new HashMap<>();
//        genreMap.put("fantasy", seriesService.findRecentSeriesByGenre("판타지", 10));
//        genreMap.put("romance", seriesService.findRecentSeriesByGenre("로맨스",10));
//        model.addAttribute("genreMap", genreMap);
//        return "home";
//    }



}
