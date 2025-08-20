package com.mywebpage.mywebpage.novel.series.service;

import com.mywebpage.mywebpage.common.ErrorMsg;
import com.mywebpage.mywebpage.common.MapStruct;
import com.mywebpage.mywebpage.novel.series.dto.SeriesDto;
import com.mywebpage.mywebpage.novel.series.entity.Series;
import com.mywebpage.mywebpage.novel.series.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final MapStruct mapStruct;
    private final ErrorMsg errorMsg;

//  전체조회
    public Page<SeriesDto> searchAll(Pageable pageable, String keyword) {
        Page<Series> page = seriesRepository.searchAll(keyword, pageable);
        return page.map(series -> mapStruct.toDto(series));
    }

//  상세조회
    public SeriesDto findById(long id) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        return mapStruct.toDto(series);
    }

//    추가
    public void save(SeriesDto dto) {
        Series series = mapStruct.toEntity(dto);
        seriesRepository.save(series);
    }

//    update
    @Transactional
    public void update(SeriesDto dto) {
        Series series = seriesRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException(errorMsg.getMessage("errors.not.found")));
        mapStruct.update(dto, series);
    }

//    삭제
    public void delete(long id) {
        seriesRepository.deleteById(id);
    }
}
