package com.vizhu.vizhu.config;
import com.vizhu.vizhu.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/").permitAll() // Разрешить доступ к главной странице для всех
                        .anyRequest().authenticated() // Требовать аутентификацию для всех остальных запросов
                )
                .formLogin() //дефолтная реализация странички по адресу /login
                .and()
                .logout((logout) -> logout
                        .logoutSuccessUrl("/") // Перенаправление после выхода
                        .permitAll()
                );

        // Настройка для использования вашего customUserDetailsService
        http.userDetailsService(customUserDetailsService);

        return http.build();
    }
}
