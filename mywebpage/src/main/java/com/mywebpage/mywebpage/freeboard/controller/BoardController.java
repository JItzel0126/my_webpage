package com.mywebpage.mywebpage.freeboard.controller;

import com.mywebpage.mywebpage.comment.boardcomment.service.BcommentService;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
import com.mywebpage.mywebpage.freeboard.entity.Board;
import com.mywebpage.mywebpage.freeboard.service.BoardService;
import com.mywebpage.mywebpage.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;
    private final BcommentService bcommentService;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

    @GetMapping("/boards")
    public String boards(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "latest") String option,
                         @PageableDefault(page = 0, size = 5) Pageable pageable,
                         Model model) {
        Page<BoardDto> dto = boardService.getBoardList(keyword, option, pageable);
        log.info(dto.getContent());
        model.addAttribute("boards", dto.getContent());
        model.addAttribute("page", dto);
        model.addAttribute("option", option);
        model.addAttribute("keyword", keyword);
        return "views/freeboard/boards";
    }

    @GetMapping("/boards/{bno}")
//    @PathVariable : URL 경로에 포함된 값을 메서드 파라미터로 가져오는 어노테이션
//    사용법 : (/url/{변수}), 함수명(@PathVariable Long 변수)
//TODO: @RequestParam 과 차이점 :
// @RequestParam은 ?뒤에 오는 쿼리스트링을 가져옴 ( 예) /boards/detail?bno=10 → @RequestParam Long bno)
// @PathVariable : @PathVariable은 경로 중에 포함된 변수를 가져옴 ( 예) /boards/10 → @PathVariable Long bno)
    public String boardDetail(@PathVariable Long bno, Model model) {
        BoardDto boardDto = boardService.getBoard(bno);  // 서비스에서 조회
        model.addAttribute("board", boardDto);
        return "views/freeboard/boardDetail";
    }

}
