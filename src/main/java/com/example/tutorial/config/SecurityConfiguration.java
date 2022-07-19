package com.example.tutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    // định nghĩa kiểu mã hóa mật khẩu (1 chiều)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Đăng ký đường dẫn để author
    // Đăng ký trang và form login
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/backend/user/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/backend/**").authenticated()
                .anyRequest().permitAll();
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .loginProcessingUrl("/doLogin")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/backend/product/list");

        http.logout().logoutUrl("/logout");

        http.csrf().disable();
        return http.build();
    }

    // ignore đường static
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

}