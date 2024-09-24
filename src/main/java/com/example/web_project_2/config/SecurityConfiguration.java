package com.example.web_project_2.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private static final String[] PERMITTED_URLS = {
                "/",
                "/users/register",
                "/users/login",
                "/error"
            };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .antMatchers(PERMITTED_URLS).permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->
                     formLogin
                        .loginPage("/users/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/home")
                        .failureForwardUrl("/error/login-error")
        ).logout(
                logout ->
                        logout.logoutUrl("/users/logout")
                                .invalidateHttpSession(true)
                                .logoutSuccessUrl("/")
        );
        return httpSecurity.build();
    }
}
