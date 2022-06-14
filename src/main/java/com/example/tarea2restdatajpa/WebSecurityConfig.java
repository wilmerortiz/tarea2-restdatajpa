package com.example.tarea2restdatajpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
          .antMatchers("/api/hello").permitAll()
          .antMatchers("/api/laptops").permitAll()
          .antMatchers("/api/laptops/{id}").permitAll()
          .antMatchers("/api/laptops/delete").hasRole("ADMIN")
          .antMatchers("/api/laptops/deleteAll").hasRole("ADMIN")
          .anyRequest()
          .authenticated()
          .and()
          .formLogin()
          .and()
          .httpBasic();
    }

    public HttpFirewall looseFirewall(){
      StrictHttpFirewall firewall = new StrictHttpFirewall();

      firewall.setAllowBackSlash(true);
      firewall.setAllowSemicolon(true);
      firewall.setAllowUrlEncodedSlash(true);

      return firewall;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
          .passwordEncoder(passwordEncoder())
          .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }

}
