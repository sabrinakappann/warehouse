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
    private static final String[] LOGIN = {"/oauth/token"};
    private static final String[] STOCK = {BASEURL + "components/**", BASEURL + "items/**", BASEURL + "compositions/**"};
    private static final String[] USERS = {BASEURL + "users/**"};
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore); // ResourceServer can no decode token
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(LOGIN).permitAll()
                .antMatchers(HttpMethod.GET, STOCK).permitAll()
                .antMatchers(HttpMethod.POST, STOCK).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, STOCK).hasRole("ADMIN")
                .antMatchers(STOCK).hasAnyRole("ADMIN", "BUYER") // don't need to put ROLE_ before
                .antMatchers(USERS).hasRole("ADMIN");
                //.anyRequest().authenticated(); // any other endpoint, it needs to be authenticated

    }
}
