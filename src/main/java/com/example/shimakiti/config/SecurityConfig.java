package com.example.shimakiti.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authenticationProvider(authenticationProvider)

            .formLogin(login -> login //  フォーム認証を使う
                    .loginPage("/login")
                    .defaultSuccessUrl("/menu")
                    .failureUrl("/login?error")
                    .permitAll()) //  フォーム認証画面は認証不要

            .logout(logout -> logout
                    .logoutSuccessUrl("/login"))

            .authorizeHttpRequests(authz -> authz
                    .requestMatchers("/css/**").permitAll() // CSSファイルは認証不要
                    .requestMatchers("/login").permitAll() //  トップページは認証不要
                    .requestMatchers("/account/**").permitAll() //  新規登録は認証不要
                    .anyRequest().authenticated() //  他のURLはログイン後アクセス可能
            );

        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User
                .withUsername("admin")
                .password("admin1234")
                .roles("ADMIN")
                .build();
        UserDetails student = User
                .withUsername("student")
                .password("student5678")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, student);
    }
}