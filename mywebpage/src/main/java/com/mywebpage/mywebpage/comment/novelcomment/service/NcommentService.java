package com.mywebpage.mywebpage.comment.novelcomment.service;

import com.mywebpage.mywebpage.comment.novelcomment.dto.NcommentDto;
import com.mywebpage.mywebpage.comment.novelcomment.entity.Ncomment;
import com.mywebpage.mywebpage.comment.novelcomment.repository.NcommentRepository;
import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import com.mywebpage.mywebpage.user.entity.User;
import com.mywebpage.mywebpage.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NcommentService {

    private final SeriesRepository seriesRepository;
    private final NcommentRepository ncommentRepository;
    private final UserRepository userRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//    댓글 불러오기(Desc 순)
//    public List<NcommentDto> findByNcomments(Long seriesId) {
//        List<Ncomment> list = ncommentRepository.findBySeriesIdOrderByCreatedAtDesc(seriesId);
//        return list.stream()
//                .map(mapStruct::toDto)
//                .toList();
//    }

    public List<NcommentDto> findByNcomments(Long id, String sort) {
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort option = Sort.by(direction, "createdAt");

        List<Ncomment> comment = ncommentRepository.findBySeriesId(id, option);
        return comment.stream().map(mapStruct::toDto).toList();
    }

//    댓글 추가
    public void save(NcommentDto dto) {
        Ncomment comment = mapStruct.toEntity(dto);

//        series id 찾기
        Series series = seriesRepository.findById(dto.getId())
                        .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        comment.setSeries(series);
//        user 세팅
        User user = userRepository.findByEmail(dto.getWriter())
                        .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        comment.setWriter(user);

        ncommentRepository.save(comment);
    }

//    댓글 삭제
    @Transactional
    public void deleteById(Long ncno) {
        ncommentRepository.deleteById(ncno);
    }
}
