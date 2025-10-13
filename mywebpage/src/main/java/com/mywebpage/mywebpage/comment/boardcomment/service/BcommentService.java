package com.mywebpage.mywebpage.comment.boardcomment.service;

import com.mywebpage.mywebpage.comment.boardcomment.dto.BcommentDto;
import com.mywebpage.mywebpage.comment.boardcomment.entity.Bcomment;
import com.mywebpage.mywebpage.comment.boardcomment.repository.BcommentRepository;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.freeboard.repository.BoardRepository;
import com.mywebpage.mywebpage.freeboard.service.BoardService;
import com.mywebpage.mywebpage.user.dto.SecurityUserDto;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BcommentService {
    private final BoardRepository boardRepository;
    private final BcommentRepository bcommentRepository;
    private final UserRepository userRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    댓글 불러오기
    public List<BcommentDto> getBcommentsByBoard(Long bno, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("createdAt").descending());
        return bcommentRepository.findByBoardBnoAndParentIsNull(bno, pageable)
                .stream().map(comments->{
                    BcommentDto dto = mapStruct.toDto(comments);
                    dto.setReplyCount(bcommentRepository.countByParent_Bcno(comments.getBcno()));
                    dto.setWriterEmail(comments.getWriter().getEmail());
                    return dto;
                }).toList();
    }

//    댓글 쓰기
    public void saveBcomment(BcommentDto bcommentDto, Long bno, String email) {
        Bcomment bcomment = mapStruct.toEntity(bcommentDto);
        bcomment.setBoard(boardRepository.findById(bno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found"))));

        // TODO: 로그인 붙이기 전까지 임시 유저 세팅
        User loginUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(errorMsg.getMessage("errors.not.found")));
        bcomment.setWriter(loginUser);

//        parent 직접 조회해서 세팅
        if(bcommentDto.getParentBcno()!=null) {
            Bcomment parent = bcommentRepository.findById(bcommentDto.getParentBcno())
                    .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
            bcomment.setParent(parent);
        }

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
    @Transactional
    public void deleteReplis(Long parentBcno) {
        bcommentRepository.deleteById(parentBcno);
    }

//    글쓴이 or 관리자만 삭제
    @Transactional
    public void deleteByOwnerOrAdmin(Long bcno, String requesterEmail,
                                     Collection<? extends GrantedAuthority> auths) {
        Bcomment c = bcommentRepository.findById(bcno)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));

        boolean isOwner = c.getWriter().getEmail().equalsIgnoreCase(requesterEmail);
        boolean isAdmin = auths.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isOwner && !isAdmin) {
            throw new RuntimeException(errorMsg.getMessage("errors.unauthorized"));
        }

        bcommentRepository.delete(c);
    }

}
