package com.linerup.lineup_backend.controller;

import com.linerup.lineup_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * packageName    : com.linerup.lineup_backend.controller
 * fileName       : MemberController
 * author         : moongi
 * date           : 12/15/23
 * description    :
 */
@Controller
//@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

}
