package com.example.oidc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author irfan.nagoo
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, ClientRegistrationRepository clientRepo) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/swagger-ui.html",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/openapi.yaml").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return httpSecurity.build();
    }

}
