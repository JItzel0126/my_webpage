package com.mywebpage.mywebpage.comment.novelcomment.controller;

import com.mywebpage.mywebpage.comment.novelcomment.dto.NcommentDto;
import com.mywebpage.mywebpage.comment.novelcomment.entity.Ncomment;
import com.mywebpage.mywebpage.comment.novelcomment.service.NcommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController = 모든 메서드에 자동 @ResponseBody 붙음
// 타임리프+화면 렌더링 타입 :
// @Controller = 기본은 뷰 반환, JSON 내려줄 땐 메서드에 @ResponseBody 붙여야 함
// Ajax 응답만 @ResponseBody로 처리
@Controller
@RequiredArgsConstructor
@RequestMapping("/ncomments")
@Log4j2
public class NcommentController {

    private final NcommentService ncommentService;

//  @Controller + @ResponseBody + 객체 리턴
//    → 뷰로 안 가고, 리턴한 객체를 JSON으로 변환해서 HTTP 응답
    @GetMapping("/{id}")
    @ResponseBody
    public List<NcommentDto> getComments(@PathVariable Long id,
                                         @RequestParam(defaultValue = "desc") String sort) {
        return ncommentService.findByNcomments(id, sort);
    }

    @PostMapping
    @ResponseBody
    public String addComment(@RequestBody NcommentDto dto) {
        ncommentService.save(dto);
        return "success";
    }

    @DeleteMapping("/{ncno}")
    @ResponseBody
    public String deleteComment(@PathVariable Long ncno) {
        ncommentService.deleteById(ncno);
        return "success";
    }


}
