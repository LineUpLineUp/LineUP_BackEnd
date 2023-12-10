package com.linerup.lineup_backend.entity.post;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Objects;

/**
 * packageName    : com.linerup.lineup_backend.common.model
 * fileName       : JobRequireMent
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */

@Embeddable
public class JobRequirement {

    String recruitGender; // 모집 성별
    @Enumerated(EnumType.STRING)
    RecruitAge recruitAge; // 모집 연령
    Integer recruitNumber; // 모집 인원

    protected JobRequirement() {
    }

    public JobRequirement(String recruitGender, RecruitAge recruitAge, Integer recruitNumber) {
        this.recruitGender = recruitGender;
        this.recruitAge = recruitAge;
        this.recruitNumber = recruitNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRequirement that = (JobRequirement) o;
        return Objects.equals(recruitGender, that.recruitGender) && Objects.equals(recruitAge, that.recruitAge) && Objects.equals(recruitNumber, that.recruitNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recruitGender, recruitAge, recruitNumber);
    }
}
