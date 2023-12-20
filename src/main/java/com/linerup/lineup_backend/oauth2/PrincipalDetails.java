package com.linerup.lineup_backend.oauth2;

import com.linerup.lineup_backend.entity.member.Member;
import com.linerup.lineup_backend.oauth2.userinfo.OAuth2UserInfo;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * packageName    : com.linerup.lineup_backend.oauth2
 * fileName       : PrincipalDetails
 * author         : moongi
 * date           : 12/13/23
 * description    :
 */
@Getter
@ToString
public class PrincipalDetails implements UserDetails, OAuth2User {
    private Member member;
    private OAuth2UserInfo oAuth2UserInfo;

    public PrincipalDetails(Member member, OAuth2UserInfo oAuth2UserInfo) {
        this.member = member;
        this.oAuth2UserInfo = oAuth2UserInfo;
    }

    /**
     * UserDetails 구현
     * 해당 유저의 권한 목록 리턴
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collect;
    }

    /**
     * OAuth2User 구현
     */
    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2UserInfo.getAttributes();
    }

    @Override
    public String getName() {
        return oAuth2UserInfo.getProviderId();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
//        return member.getNickname();
        return member.getName();
    }

    /**
     * 계정 만료 여부
     * true: 만료 안됨
     * false: 만료됨
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 계정 활성화 여부
     * true: 활성화됨
     * false: 활성화 안됨
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
