package com.linerup.lineup_backend.domain.repository;


import com.linerup.lineup_backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByProviderId(String providerId);
}
