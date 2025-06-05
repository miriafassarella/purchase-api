package com.purchase.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration /*Esta falando para o spring que esta classe contem beans de configuração*/
@EnableWebSecurity //ativa o spring security na aplicacação
public class SecurityConfig {

    /*SecurityFilterChain : define as regras de segurança*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth// quais requisições devem ser autenticadas
                        .anyRequest().authenticated()//todas as requisições deves ser autenticadas
                )
                .httpBasic()//define o modo de autenticação et o navegador ou cliente pergunta pour login et senha
                .and()
                .sessionManagement(sess -> sess //configura a politica de sessão
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//stateless: a cada sessão o usuario precisa se autenticar
                )
                .csrf().disable(); //proteção contra falsificação de requisição entre sites.

        return http.build();// constroi e retorna o SecurityFilterChain com todas essas configuraçãoes.
    }

    /*Configurando o usuario em mémoria
    * Cria um usuario com login admin e senha admin, com o papel ROLE_ADMIN*/
    @Bean
    public UserDetailsService userDetailsService() {
        // Usuário de teste em memória
        var user = User
                .withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user); //armazena usuários apenas na memória
    }

    //NoOpPasswordEncoder : não codifica a senha, usa a senha pura do jeito que foi digitada.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Não usar em produção
    }

    /*
    * Em produção :
            @Bean
            public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
            }
             E encodamos a senha :
            .password(passwordEncoder().encode("admin"))
             */
}
