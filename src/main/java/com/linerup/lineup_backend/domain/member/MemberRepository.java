package com.linerup.lineup_backend.domain.member;

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
