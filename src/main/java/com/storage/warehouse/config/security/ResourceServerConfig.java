package com.storage.warehouse.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    JwtTokenStore jwtTokenStore;
    private static final String BASEURL = "/api/v1/";
    private static final String[] PUBLIC = {"/oauth/token"};
    private static final String[] BUYER_OR_ADMIN = {BASEURL + "components/**", BASEURL + "items/**", BASEURL + "compositions/**"};
    private static final String[] ADMIN = {BASEURL + "users/**"};
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore); // ResourceServer can no decode token
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC)
                .permitAll()
                .antMatchers(HttpMethod.GET, BUYER_OR_ADMIN).permitAll()
                .antMatchers(BUYER_OR_ADMIN).hasAnyRole("ROLE_ADMIN", "ROLE_BUYER") // dont need to put ROLE_ before
                .antMatchers(ADMIN).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, BUYER_OR_ADMIN).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, BUYER_OR_ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated(); // any other endpoint, it needs to be authenticated
    }
}
