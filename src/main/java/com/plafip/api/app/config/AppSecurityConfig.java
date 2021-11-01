package com.plafip.api.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(request -> {
            var conf = new CorsConfiguration();
            conf.applyPermitDefaultValues();
            conf.addAllowedOrigin(CorsConfiguration.ALL);
            conf.addAllowedHeader(CorsConfiguration.ALL);
            conf.addExposedHeader(CorsConfiguration.ALL);
            return conf;
        });
    }
}
