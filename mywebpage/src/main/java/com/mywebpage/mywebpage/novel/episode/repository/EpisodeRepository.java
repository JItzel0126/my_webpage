package com.mywebpage.mywebpage.novel.episode.repository;

import com.mywebpage.mywebpage.novel.episode.entity.Episode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

//    에피소드 넘버 오름차순
    List<Episode> findBySeriesIdOrderByEpiNumberAsc(Long seriesId);
//    에피소드 넘버 내림차순
    List<Episode> findBySeriesIdOrderByEpiNumberDesc(Long seriesId);
}
