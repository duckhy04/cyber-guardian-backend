package org.example.cyberguardianbackend.config;

import lombok.RequiredArgsConstructor;
import org.example.cyberguardianbackend.filters.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)  // Vô hiệu hóa CSRF vì API sử dụng JWT
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/authenticate", "/sign-up").permitAll()  // Các route này không cần xác thực
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")  // Các route API yêu cầu xác thực
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")  // Các route API yêu cầu xác thực
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Không sử dụng session, chỉ sử dụng JWT
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)  // Thêm JWT filter trước UsernamePassword filter
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
