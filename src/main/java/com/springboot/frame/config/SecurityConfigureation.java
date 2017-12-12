package com.springboot.frame.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*@Profile("dev")
@Configuration*/
public class SecurityConfigureation extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
        http.logout().logoutUrl("/logout");
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**").permitAll();

        http.authorizeRequests().antMatchers("/api/**").permitAll().antMatchers("/**")
                .authenticated();

        // Enable so that the clients can authenticate via HTTP basic for registering
        http.httpBasic();
    }

}
