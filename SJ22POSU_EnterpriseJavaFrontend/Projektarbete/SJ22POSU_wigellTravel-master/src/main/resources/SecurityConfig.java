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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Configuration
public class SecurityConfig {
    private static final Logger logger = LogManager.getLogger(SecurityConfig.class);

/*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select login_namne,login_password from tbl_auth where login_namne=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select id,role from tbl_auth_role where id = ?");
        return jdbcUserDetailsManager;
    }
*/

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
                        .requestMatchers(HttpMethod.GET, "/api/v1/trips/**").anonymous()

                        .requestMatchers(HttpMethod.POST, "/api/v1/trips").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/trips/**").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/trips/**").hasAnyRole("USER")

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
}