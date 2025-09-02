package com.mywebpage.mywebpage.novel.series.repository;

import com.mywebpage.mywebpage.novel.series.entity.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

    @Query(value = "select s from Series s\n" +
                    "where LOWER(s.title) like LOWER(concat('%',:keyword,'%'))\n"+
                    "or LOWER(s.author) like LOWER(concat('%',:keyword,'%'))\n"+
                    "or LOWER(s.publisher) like LOWER(concat('%',:keyword,'%'))"+
                    "or LOWER(s.genre) like LOWER(concat('%',:keyword,'%'))")
    Page<Series> searchAll(@Param("keyword") String keyword,
                                      Pageable pageable);

    Page<Series> findByOrderByIdDesc(Pageable pageable);

    Page<Series> findByGenreOrderByIdDesc(String genre, Pageable pageable);

}
