package com.linerup.lineup_backend.like.command.domain;

import com.linerup.lineup_backend.member.command.domain.Member;
import com.linerup.lineup_backend.post.command.domain.Post;
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
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
