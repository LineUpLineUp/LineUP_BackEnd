package com.linerup.lineup_backend.security.oauth2.user;
/**
* @author :
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.user
* @name : CustomOAuth2User.java
* @date : 2023/08/25 2:52 AM
* @modified :
**/
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.linerup.lineup_backend.common.model.Id;
import com.linerup.lineup_backend.common.model.Role;
import com.linerup.lineup_backend.domain.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User, Serializable {

  private final Id<Member, Long> id;

  private final Role role;

  private final OAuth2User oAuth2User;

  public CustomOAuth2User(Long id, Role role, OAuth2User oAuth2User) {
    Preconditions.checkArgument(id != null, "id must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");
    Preconditions.checkArgument(oAuth2User != null, "oAuth2User must be provided.");

    this.id = Id.of(Member.class, id);
    this.role = role;
    this.oAuth2User = oAuth2User;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return oAuth2User.getAttributes();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return oAuth2User.getAuthorities();
  }

  @Override
  public String getName() {
    return oAuth2User.getName();
  }

  public Id<Member, Long> getId() {
    return id;
  }

  public Role getRole() {
    return role;
  }

  public OAuth2User getOAuth2User() {
    return oAuth2User;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomOAuth2User that = (CustomOAuth2User) o;
    return Objects.equal(id, that.id) && role == that.role
      && Objects.equal(oAuth2User, that.oAuth2User);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, role, oAuth2User);
  }
}
