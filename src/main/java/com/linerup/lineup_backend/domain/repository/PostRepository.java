package com.linerup.lineup_backend.domain.repository;

import com.linerup.lineup_backend.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.linerup.lineup_backend.domain.repository
 * fileName       : PostRepository
 * author         : moongi
 * date           : 12/1/23
 * description    :
 */

public interface PostRepository extends JpaRepository<Post, Long> {
}
