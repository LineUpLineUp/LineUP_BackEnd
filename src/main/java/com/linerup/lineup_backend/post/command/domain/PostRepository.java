package com.linerup.lineup_backend.post.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.linerup.lineup_backend.domain.post
 * fileName       : PostRepository
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
