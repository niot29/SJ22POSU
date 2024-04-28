package se.wigell.wtravels.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(authz ->
                authz
                        //.requestMatchers("/").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()

                        //.requestMatchers(PathRequest.toH2Console()).permitAll()
                        //.requestMatchers(HttpMethod.GET, "/api/v1/trips/**")

                        .requestMatchers(HttpMethod.POST, "/api/v1/trips").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/trips/**").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/trips/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/v1/destinations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/destinations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/destinations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/destinations/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/v1/customers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/customers/**").hasRole("ADMIN")



                        .anyRequest().authenticated()

        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }


/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity.authorizeHttpRequests(reistry->{
            //reistry.requestMatchers("/").permitAll();
            reistry.requestMatchers(PathRequest.toH2Console()).permitAll();
            reistry.requestMatchers("/swagger-ui/").permitAll();
            reistry.requestMatchers("/api/v1/h2-console/").permitAll();
            reistry.requestMatchers("/api/v1/trips/**").hasRole("USER");
            reistry.requestMatchers("/api/v1/customers").hasRole("ADMIN");

            reistry.anyRequest().authenticated();

        }).build();
    }
*/
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user01 = User.builder()
                .username("user01")
                .password("{noop}pass") //Userpassword
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}tass")  //Adminpassword
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user01, admin);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
