package com.learning.ote.spring.mvc.auth;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.io.IOException;
import java.util.Map;

public class Oauth2ClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String token = extractAccessToken(authentication);

            request.getHeaders().setBearerAuth(token);
        }

        return execution.execute(request, body);
    }

    private String extractAccessToken(Authentication authentication) {
        DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();

        Map<String, String> details = principal.getAttribute("details");
        return details.get("tokenValue");
    }
}
