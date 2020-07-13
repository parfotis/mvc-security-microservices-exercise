package com.learning.ote.spring.mvc.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${oauth2.server.logout.url}")
    private String logoutUrl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessUrl(logoutUrl);
    }

    @Bean
    OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return new CustomOAuth2UserService();
    }
}
