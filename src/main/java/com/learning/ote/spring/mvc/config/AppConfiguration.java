package com.learning.ote.spring.mvc.config;

import com.learning.ote.spring.mvc.auth.Oauth2ClientHttpRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
@PropertySource("classpath:messages.properties")
@EnableOAuth2Client
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate secureRestTemplate(Oauth2ClientHttpRequestInterceptor oauth2ClientHttpRequestInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(oauth2ClientHttpRequestInterceptor));
        return restTemplate;
    }

    @Bean
    public Oauth2ClientHttpRequestInterceptor oauth2ClientHttpRequestInterceptor() {
        return new Oauth2ClientHttpRequestInterceptor();
    }

}
