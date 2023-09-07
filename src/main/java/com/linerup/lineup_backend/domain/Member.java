package com.linerup.lineup_backend.domain;
/**
 * @author :
 * @version : 1.0.0
 * @package : com.linerup.lineup_backend.domain
 * @name : Member.java
 * @date : 2023/08/25 2:53 AM
 * @modified :
 **/

import com.google.common.base.Objects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private OAuth2Provider provider;

    @Column(length = 50, nullable = false, unique = true)
    private String providerId;

    @Column(nullable = true)
    private String userEmail;
    @Column(nullable = true)
    private String userName;

    @Column(nullable = false)
    private String userNickname;

    @Column(nullable = false)
    private String userPhone;

    @Column(nullable = true)
    private String userProfileImage;

    @Column(nullable = false)
    private LocalDate userBirth;



    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Role role;

    protected Member() {
    }

    public Member(OAuth2Provider provider, String providerId, String userEmail, String userName) {

        this(null, provider, providerId, Role.ROLE_USER, userEmail, userName);
    }

    private Member(Long id, OAuth2Provider provider, String providerId, Role role, String userEmail, String userName) {
        this.id = id;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equal(id, member.id) && provider == member.provider
                && Objects.equal(providerId, member.providerId) && role == member.role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, provider, providerId, role);
    }

}
