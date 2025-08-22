package com.mywebpage.mywebpage.freeboard.service;

import com.mywebpage.mywebpage.comment.boardcomment.repository.BcommentRepository;
import com.mywebpage.mywebpage.comment.boardcomment.service.BcommentService;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.freeboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BcommentRepository bcommentRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    like 조회
    public Page<BoardDto> searchBoardList(String keyword, Pageable pageable) {
        Page<Board> boards=boardRepository.searchBoardList(keyword, pageable);
        return boards.map(data -> mapStruct.toDto(data));
    }

//    게시판
    public Page<BoardDto> getBoardList(String option, Pageable pageable) {
        if("oldest".equals(option)) {
            pageable = PageRequest.of(pageable.getPageNumber(),
                                      pageable.getPageSize(),
                                      Sort.by("createdAt").ascending());
        }
        else if("like".equals(option)) {
            pageable = PageRequest.of(pageable.getPageNumber(),
                                      pageable.getPageSize(),
                                      Sort.by("likeCount").descending());
        }
        else if("view".equals(option)) {
            pageable = PageRequest.of(pageable.getPageNumber(),
                                      pageable.getPageSize(),
                                      Sort.by("viewCount").descending());
        }
        else {
            pageable = PageRequest.of(pageable.getPageNumber(),
                                      pageable.getPageSize(),
                                      Sort.by("createdAt").descending());
        }
        Page<Board> board=boardRepository.findAll(pageable);
        return board.map(data -> mapStruct.toDto(data));
    }

//    추가
    public void save(BoardDto boardDto) {
        Board board = mapStruct.toEntity(boardDto);
        boardRepository.save(board);
    }

//    삭제
    public void delete(long bno) {
        boardRepository.deleteById(bno);
    }

//    업데이트
    @Transactional
    public void update(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getBno())
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        mapStruct.update(boardDto, board);
    }

//    댓글수 가져오기
    public int getCommentsCountByBoard(long bno) {
        return bcommentRepository.countByBoardBno(bno);
    }

}
