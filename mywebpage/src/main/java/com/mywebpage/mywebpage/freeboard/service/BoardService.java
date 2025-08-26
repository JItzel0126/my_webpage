package com.mywebpage.mywebpage.freeboard.service;

import com.mywebpage.mywebpage.comment.boardcomment.repository.BcommentRepository;
import com.mywebpage.mywebpage.comment.boardcomment.service.BcommentService;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.freeboard.repository.BoardRepository;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    like 조회
//    public Page<BoardDto> searchBoardList(String keyword, Pageable pageable) {
//        Page<Board> boards=boardRepository.searchBoardList(keyword, pageable);
//        return boards.map(data -> mapStruct.toDto(data));
//    }

//    게시판
    public Page<BoardDto> getBoardList(String keyword, String option, Pageable pageable) {
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
        // 검색 + 정렬 함께 처리
        Page<Board> board;
        if (keyword != null && !keyword.isBlank()) {
            board = boardRepository.searchBoardList(keyword, pageable);
        } else {
            board = boardRepository.findAll(pageable);
        }
        return board.map(data -> mapStruct.toDto(data));
    }

//    상세조회
    public BoardDto getBoard(long bno) {
        Board board=boardRepository.findById(bno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        return mapStruct.toDto(board);
    }

//    추가
    public void save(BoardDto boardDto) {
        Board board = mapStruct.toEntity(boardDto);

        // 임시 작성자 고정(로그인 기능 작성 전)
        User dummy = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException(errorMsg.getMessage("errors.not.found")));
        board.setWriter(dummy);

        boardRepository.save(board);
    }

//    삭제
//  @Transactional : 실무에서 삭제 시 다른 연관관계까지 cascade 처리하는 경우가 많기 때문에 사용
    @Transactional
    public void delete(Long bno) {
        boardRepository.deleteById(bno);
    }

//    업데이트
    @Transactional
    public void update(Long bno, BoardDto boardDto) {
        Board board = boardRepository.findById(bno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        mapStruct.update(boardDto, board);
    }

//    댓글수 가져오기
    public int getCommentsCountByBoard(long bno) {
        return bcommentRepository.countByBoardBno(bno);
    }

}
