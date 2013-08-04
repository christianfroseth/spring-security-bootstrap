package com.christianfroseth.springsecuritybootstrap.config.securityconfig;

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 8/4/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security config
 * User: Christian Froseth
 * Date: 8/4/13
 * Time: 12:40 AM
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Set up in-memory user
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN", "USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/**");
    }

    /**
     * Matcher rules and setup
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeUrls()
                .antMatchers("/*").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html?logout")
                .and()
                .formLogin()
                .loginUrl("/login.html")
                .defaultSuccessUrl("/admin/admin.html", true)
                .failureUrl("/login.html?failed")
                .permitAll();
    }
}