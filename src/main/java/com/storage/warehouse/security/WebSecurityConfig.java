package com.storage.warehouse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService myUserDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/actuator/**"); // allow all endpoints spring cloud OAuth uses this 'actuator'
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure that bcrypt is beeing use to cript passwords
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder);
        // now its configured how to get username and encode its password
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); // autorization server will use this man
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("DNEKCAB-ORP-ANIRBAS");
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}