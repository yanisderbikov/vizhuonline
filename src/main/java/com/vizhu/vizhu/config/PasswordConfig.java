package com.vizhu.vizhu.config;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // TODO: 12/03/24 Заинжектить реализацию
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                log.debug(rawPassword);
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                var match = rawPassword.toString().equals(encodedPassword);
                log.debug(String.format("match: %s, raw: %s, encoded:%s", match, rawPassword, encodedPassword));
                return match;
            }
        };
    }
}
