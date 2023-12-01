package com.linerup.lineup_backend.domain.member;

import com.linerup.lineup_backend.common.model.BaseEntity;
import com.linerup.lineup_backend.domain.OAuth2Provider;
import com.linerup.lineup_backend.common.model.Role;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * packageName    : com.linerup.lineup_backend.domain.member
 * fileName       : Member
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */
@Entity
@Getter
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 id

    @Nonnull
    @Enumerated(EnumType.STRING)
    private OAuth2Provider provider;

    @Nonnull
    private String providerId;

    @Nonnull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Nonnull
    private String email; // 이메일

    @Nonnull
    private String nickname; // 별명

    private String name; // 이름(PASS)

    private String phone; // 핸드폰 번호(PASS)

    private LocalDateTime birth; // 생년월일(PASS)

    private String gender; // 성별(PASS)

    private String profileImage; // 프로필 이미지

    @Nonnull
    private boolean isAuthenticated = false; // 본인 인증 여부(PASS)

    protected Member() {
    }

    public Member(Long id, OAuth2Provider provider, String providerId, Role role, String email, String nickname, String name, String phone, LocalDateTime birth, String gender, String profileImage, boolean isAuthenticated) {
        this.id = id;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.profileImage = profileImage;
        this.isAuthenticated = isAuthenticated;
    }

    public Member(OAuth2Provider provider, String providerId, String email, String name) {
        this.provider = provider;
        this.providerId = providerId;
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return isAuthenticated() == member.isAuthenticated() && Objects.equals(getId(), member.getId()) && getProvider() == member.getProvider() && Objects.equals(getProviderId(), member.getProviderId()) && getRole() == member.getRole() && Objects.equals(getEmail(), member.getEmail()) && Objects.equals(getNickname(), member.getNickname()) && Objects.equals(getName(), member.getName()) && Objects.equals(getPhone(), member.getPhone()) && Objects.equals(getBirth(), member.getBirth()) && Objects.equals(getGender(), member.getGender()) && Objects.equals(getProfileImage(), member.getProfileImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProvider(), getProviderId(), getRole(), getEmail(), getNickname(), getName(), getPhone(), getBirth(), getGender(), getProfileImage(), isAuthenticated());
    }
}
