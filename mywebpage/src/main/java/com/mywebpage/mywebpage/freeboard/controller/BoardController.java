package com.mywebpage.mywebpage.freeboard.controller;

import com.mywebpage.mywebpage.comment.boardcomment.service.BcommentService;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
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
import org.springframework.web.bind.annotation.RequestParam;

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

}
