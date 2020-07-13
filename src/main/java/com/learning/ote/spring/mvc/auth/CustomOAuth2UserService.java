package com.learning.ote.spring.mvc.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();
        List<LinkedHashMap<String, String>> authoritiesAttribute = (List<LinkedHashMap<String, String>>) attributes.get("authorities");

        List<GrantedAuthority> grantedAuthorities = authoritiesAttribute.stream()
                .flatMap(authorities -> authorities.values().stream())
                .map(authority -> new OAuth2UserAuthority(authority, attributes))
                .collect(Collectors.toList());

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
        return new DefaultOAuth2User(grantedAuthorities, attributes, userNameAttributeName);
    }

}
