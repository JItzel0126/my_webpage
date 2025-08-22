package com.mywebpage.mywebpage.freeboard.repository;

import com.mywebpage.mywebpage.freeboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//   like 조회
    @Query(value = "select b from Board b\n" +
                    "where lower(b.title) like lower(concat('%',:keyword,'%'))\n" +
                    "or lower(b.content) like lower(concat('%',:keyword,'%'))\n" +
                    "or lower(b.writer.name) like lower(concat('%',:keyword,'%'))")
    Page<Board> searchBoardList(@Param("keyword") String keyword,
            Pageable pageable);

}
