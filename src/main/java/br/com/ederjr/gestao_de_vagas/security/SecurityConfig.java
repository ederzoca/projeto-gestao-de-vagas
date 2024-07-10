package br.com.ederjr.gestao_de_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean                                                                                        // @Bean -> Indica que o método está sendo utilizado para definir algum objeto que já é gerenciado pelo Spring
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {                // Sobreescreve as configurações do SecurityFilterChain
        http.csrf(csrf -> csrf.disable())                                                        // Desabilita as configurações do SpringSecurity pra configurar manualmente.
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate/create").permitAll()              // Indicando AUTORIZAÇÕES para fazer requisições
                            .requestMatchers("/candidate/list").permitAll()
                            .requestMatchers("/candidate/list/{username}").permitAll()
                            .requestMatchers("/candidate/update/{username}").permitAll()
                            .requestMatchers("/company/create").permitAll()
                            .requestMatchers("/company/list").permitAll()
                            .requestMatchers("/auth/company").permitAll();
                    auth.anyRequest().authenticated();                                          // Indicando que para qualquer outra requisição precisa ser AUTENTICADO
                });
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();                                                     // Configurações para fazer a criptografia da senha
    }
}
