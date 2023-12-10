package com.linerup.lineup_backend.repository;

import com.linerup.lineup_backend.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.linerup.lineup_backend.domain.member
 * fileName       : MemberRepository
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */

public interface MemberRepository extends JpaRepository<Member, Long> {

}
