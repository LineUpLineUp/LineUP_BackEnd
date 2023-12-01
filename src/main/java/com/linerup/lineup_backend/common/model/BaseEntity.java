package com.linerup.lineup_backend.common.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName    : com.linerup.lineup_backend.common.model
 * fileName       : BaseEntity
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    private LocalDateTime createdDate; // 생성 시간
    private LocalDateTime modifiedDate; // 수정 시간



}
