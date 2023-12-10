package com.linerup.lineup_backend.entity.post;

import com.linerup.lineup_backend.common.model.*;
import com.linerup.lineup_backend.entity.member.Member;
import com.linerup.lineup_backend.entity.Place;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

/**
 * packageName    : com.linerup.lineup_backend.domain.post
 * fileName       : Post
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */

@Getter
@Entity
@ToString
@RequiredArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 공고 id

    @Nonnull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Nonnull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @Nonnull
    private String title; // 공고 제목

    @Nonnull
    private LocalDateTime startDate; // 근무 시작 시간

    @Nonnull
    private LocalDateTime endDate; // 근무 종료 시간

    @Nonnull
    private long salary; // 급여

    private String image; // 사진

    private JobRequirement jobRequireMent; // 지원 자격

    @Nonnull
    private String content; // 공고 내용

    private boolean isAgree; // 라인업 줄서기 대행 준수사항 동의

    private Integer viewCount; // 조회수

    private Integer likeCount; // 좋아요 개수

    @Enumerated(EnumType.STRING)
    private Category category; // 카테고리

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus; // 구인 현황

}
