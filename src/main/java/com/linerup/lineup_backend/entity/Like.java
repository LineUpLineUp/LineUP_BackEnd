package com.linerup.lineup_backend.entity;

import com.linerup.lineup_backend.entity.member.Member;
import com.linerup.lineup_backend.entity.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.linerup.lineup_backend.domain
 * fileName       : Like
 * author         : moongi
 * date           : 12/8/23
 * description    :
 */
@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
