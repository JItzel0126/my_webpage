// BaseTimeEntity.java

package com.mywebpage.mywebpage.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseTimeEntity {
//    생성 날짜, 업데이트 X
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;
//    마지막 수정 날짜
    @LastModifiedDate
    private LocalDateTime updateAt;

}
