package com.mywebpage.mywebpage.comment.novelcomment.repository;

import com.mywebpage.mywebpage.comment.novelcomment.entity.Ncomment;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NcommentRepository extends JpaRepository<Ncomment, Long> {

//    댓글 최신순 불러오기
    List<Ncomment> findBySeriesIdOrderByCreatedAtDesc(Long seriesId);
//    댓글 오래된순 불러오기
    List<Ncomment> findBySeriesIdOrderByCreatedAtAsc(Long seriesId);

//    댓글 불러오기
    List<Ncomment> findBySeriesId(Long seriesId, Sort sort);



}
