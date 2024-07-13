package br.com.ederjr.gestao_de_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate/create").permitAll()
                            .requestMatchers("/candidate/list").permitAll()
                            .requestMatchers("/candidate/list/{username}").permitAll()
                            .requestMatchers("/candidate/update/{username}").permitAll()
                            .requestMatchers("/company/create").permitAll()
                            .requestMatchers("/company/list").permitAll()
                            .requestMatchers("/auth/company").permitAll();
                    auth.anyRequest().authenticated();
                });
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {                                                              // Configurações para fazer a criptografia da senha
        return new BCryptPasswordEncoder();
    }
}
