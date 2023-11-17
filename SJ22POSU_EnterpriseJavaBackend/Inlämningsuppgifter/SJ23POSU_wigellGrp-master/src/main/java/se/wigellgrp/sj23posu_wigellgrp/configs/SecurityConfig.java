package se.wigellgrp.sj23posu_wigellgrp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails user01 = User.builder()
                .username("user01")
                .password("{noop}tass")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}pass")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user01, admin);

    }


    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(authz ->
                authz
                        .requestMatchers(HttpMethod.GET,"/mypages/members").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET,"/mypages/members/**").hasAnyRole("USER","ADMIN")

                        .requestMatchers(HttpMethod.GET,"/admin/members").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/admin/members").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/admin/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/admin/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/admin/members/**").hasRole("ADMIN")

                        .anyRequest().authenticated()

        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
