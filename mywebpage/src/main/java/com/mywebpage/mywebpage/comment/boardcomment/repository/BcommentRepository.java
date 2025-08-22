package com.mywebpage.mywebpage.comment.boardcomment.repository;

import com.mywebpage.mywebpage.comment.boardcomment.entity.Bcomment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcommentRepository extends JpaRepository<Bcomment, Long> {

//    댓글 수 세기
    int countByBoardBno(Long bno);

    int countByParent_Bcno(Long parentBcno);

//    댓글만 불러오기
    List<Bcomment> findByBoardBnoAndParentIsNull(Long bno, Pageable pageable);

//    대댓글
    List<Bcomment> findByParentBcnoOrderByCreatedAtDesc(Long parentBcno);

}
