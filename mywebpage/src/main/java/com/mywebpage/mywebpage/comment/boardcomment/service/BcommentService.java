package com.mywebpage.mywebpage.comment.boardcomment.service;

import com.mywebpage.mywebpage.comment.boardcomment.dto.BcommentDto;
import com.mywebpage.mywebpage.comment.boardcomment.entity.Bcomment;
import com.mywebpage.mywebpage.comment.boardcomment.repository.BcommentRepository;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.repository.BoardRepository;
import com.mywebpage.mywebpage.freeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BcommentService {
    private final BoardRepository boardRepository;
    private final BcommentRepository bcommentRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    댓글 불러오기
    public List<BcommentDto> getBcommentsByBoard(Long bno, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("createdAt").descending());
        return bcommentRepository.findByBoardBnoAndParentIsNull(bno, pageable)
                .stream().map(comments->{
                    BcommentDto dto = mapStruct.toDto(comments);
                    dto.setReplyCount(bcommentRepository.countByParent_Bcno(comments.getBcno()));
                    return dto;
                }).toList();
    }

//    댓글 쓰기
    public void saveBcomment(BcommentDto bcommentDto, Long bno) {
        Bcomment bcomment = mapStruct.toEntity(bcommentDto);
        bcomment.setBoard(boardRepository.findById(bno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found"))));
        bcommentRepository.save(bcomment);
    }

//    대댓글 불러오기
    public List<BcommentDto> getReplis(Long parentBcno) {
        return bcommentRepository.findByParentBcnoOrderByCreatedAtDesc(parentBcno)
                .stream().map(mapStruct::toDto).toList();
    }

//    대댓글 쓰기
    public void saveReplis(BcommentDto bcommentDto, Long parentBcno) {
        Bcomment reply = mapStruct.toEntity(bcommentDto);
        Bcomment parent = bcommentRepository.findById(parentBcno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        reply.setParent(parent);
        reply.setBoard(parent.getBoard());  // 같은 게시판 연결
        bcommentRepository.save(reply);
    }

//    삭제
    public void deleteReplis(Long parentBcno) {
        bcommentRepository.deleteById(parentBcno);
    }

}
