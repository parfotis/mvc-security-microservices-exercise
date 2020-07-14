package com.learning.ote.spring.mvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@PropertySource("classpath:messages.properties")
@EnableOAuth2Client
public class AppConfiguration implements WebMvcConfigurer {

    @Value("${spring.security.oauth2.client.registration.custom-client.client-id")
    private String clientID;

    @Value("${spring.security.oauth2.client.registration.custom-client.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.custom-provider.token-uri}")
    private String accessTokenUri;

    @Value("${spring.security.oauth2.client.provider.custom-provider.authorization-uri}")
    private String userAuthorizationUri;

    @Value("${spring.security.oauth2.client.registration.custom-client.scope}")
    private String scope;

    @Value("${spring.security.oauth2.client.registration.custom-client.redirect-uri}")
    private String redirectUri;


    @Bean
    public OAuth2ProtectedResourceDetails reddit() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("Auth server");
        details.setClientId(clientID);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setTokenName("oauth_token");
        details.setScope(Collections.singletonList(scope));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ProtectedResourceDetails details) {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(details);

        /* To validate if required configurations are in place during startup */
        oAuth2RestTemplate.getAccessToken();
        return oAuth2RestTemplate;
    }

}
