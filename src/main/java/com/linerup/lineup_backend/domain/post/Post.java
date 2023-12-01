package com.linerup.lineup_backend.domain.post;

import com.linerup.lineup_backend.common.model.BaseEntity;
import com.linerup.lineup_backend.common.model.JobRequirement;
import com.linerup.lineup_backend.common.model.Place;
import com.linerup.lineup_backend.domain.member.Member;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

/**
 * packageName    : com.linerup.lineup_backend.domain.post
 * fileName       : Post
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */

@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 공고 id

    @Nonnull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Nonnull
    private String title; // 공고 제목

    @Nonnull
    private LocalDateTime startDate; // 근무 시작 시간

    @Nonnull
    private LocalDateTime endDate; // 근무 종료 시간

    @Nonnull
    private Place place; // 근무지 정보

    @Nonnull
    private long salary; // 급여

    private String image; // 사진

    private JobRequirement jobRequireMent; // 지원 자격

    @Nonnull
    private String content; // 공고 내용

    private boolean isAgree; // 라인업 줄서기 대행 준수사항 동의




}
