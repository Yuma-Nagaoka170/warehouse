package com.example.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // メモリ上でユーザーを作成（必要に応じてDBに変更）
        return new InMemoryUserDetailsManager(
            User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER").build(),
            User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> 
                authz
                    .requestMatchers("/", "/products/**", "/stocks", "/orders", "/shipments/**", "/locations/**", "/css/**", "/js/**").permitAll()  // 公開ページ
                    .anyRequest().authenticated()  // その他のリクエストは認証必須
            )
            .formLogin(form -> 
            form
                .loginPage("/login")
                .successHandler(successHandler()) // デフォルトURLではなく元のリクエストへ戻る
                .permitAll()
        )
            .logout(logout -> 
                logout
                    .logoutUrl("/logout")  // ログアウトURL
                    .logoutSuccessUrl("/")  // ログアウト後のリダイレクト先
                    .permitAll()  // ログアウトも誰でも許可
            );

        return http.build();  // Spring Security 5.x では http.build() を使う
    }
    
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        // 元のリクエストに戻るためのハンドラー
        return new SavedRequestAwareAuthenticationSuccessHandler();
    }
}
