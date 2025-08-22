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

//    대댓글 불러오기
    public List<BcommentDto> getReplis(Long parentBcno) {
        return bcommentRepository.findByParentBcnoOrderByCreatedAtDesc(parentBcno)
                .stream().map(mapStruct::toDto).toList();
    }
}
