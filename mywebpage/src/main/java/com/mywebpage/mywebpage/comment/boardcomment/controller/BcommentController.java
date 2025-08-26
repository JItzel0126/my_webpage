package com.mywebpage.mywebpage.comment.boardcomment.controller;

import com.mywebpage.mywebpage.comment.boardcomment.dto.BcommentDto;
import com.mywebpage.mywebpage.comment.boardcomment.entity.Bcomment;
import com.mywebpage.mywebpage.comment.boardcomment.service.BcommentService;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.freeboard.dto.BoardDto;
import com.mywebpage.mywebpage.freeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BcommentController {
    private final BoardService boardService;
    private final BcommentService bcommentService;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    조회
//    @GetMapping("/boards/{bno}/comments")
//    @ResponseBody
//    public List<BcommentDto> boardComments(@PathVariable Long bno,
//                                           @RequestParam(defaultValue = "0") int page,
//                                           @RequestParam(defaultValue = "10") int size) {
//        return bcommentService.getBcommentsByBoard(bno, page, size);
//    }

}
