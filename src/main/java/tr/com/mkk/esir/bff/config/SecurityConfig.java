package tr.com.mkk.esir.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security) {
        security.cors()
                .and()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/api/auth/**")
                .permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer().jwt();

        return security.build();
    }
}
