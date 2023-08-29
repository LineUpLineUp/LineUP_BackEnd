package com.linerup.lineup_backend.oauth2.repository;

import com.linerup.lineup_backend.oauth2.component.OAuth2AuthorizationRequestFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : LineUP_BackEnd
 * @name : CustomOAuth2AuthorizationRequestRepository
 * @date : 2023/08/29 2:04 PM
 * @modifyed : $
 **/
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
    private static final String DEFAULT_AUTHORIZATION_REQUEST_ATTR_NAME = CustomAuthorizationRequestRepository.class
            .getName() + ".AUTHORIZATION_REQUEST";

    private final String sessionAttributeName = DEFAULT_AUTHORIZATION_REQUEST_ATTR_NAME;
    private final OAuth2AuthorizationRequestFactory oAuth2AuthorizationRequestFactory;

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        Assert.notNull(request, "request cannot be null");
        String stateParameter = getStateParameter(request);
        if (stateParameter == null) {
            return null;
        }
        OAuth2AuthorizationRequest authorizationRequest = getAuthorizationRequest(request);
        return (authorizationRequest != null && stateParameter.equals(authorizationRequest.getState()))
                ? authorizationRequest : null;
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request,
                                         HttpServletResponse response) {
        Assert.notNull(request, "request cannot be null");
        Assert.notNull(response, "response cannot be null");
        if (authorizationRequest == null) {
            removeAuthorizationRequest(request, response);
            return;
        }
        String state = authorizationRequest.getState();
        Assert.hasText(state, "authorizationRequest.state cannot be empty");
        request.getSession().setAttribute(this.sessionAttributeName, authorizationRequest);
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request,
                                                                 HttpServletResponse response) {
        log.debug("request = " + request);
        Assert.notNull(response, "response cannot be null");
        OAuth2AuthorizationRequest authorizationRequest = loadAuthorizationRequest(request);
        if (authorizationRequest != null) {
            request.getSession().removeAttribute(this.sessionAttributeName);
        }
        return authorizationRequest;
    }

    /**
     * Gets the state parameter from the {@link HttpServletRequest}
     * @param request the request to use
     * @return the state parameter or null if not found
     */
    private String getStateParameter(HttpServletRequest request) {
        return request.getParameter(OAuth2ParameterNames.STATE);
    }

    private OAuth2AuthorizationRequest getAuthorizationRequest(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getSession();
        }

        OAuth2AuthorizationRequest oAuth2AuthorizationRequest = (OAuth2AuthorizationRequest) session.getAttribute(this.sessionAttributeName);
        if(oAuth2AuthorizationRequest == null){
            log.debug("request = " + request.getRequestURI());
            return oAuth2AuthorizationRequestFactory.makeOAuth2AuthorizationRequest(request);
        }

        return (OAuth2AuthorizationRequest) session.getAttribute(this.sessionAttributeName);
    }
}

