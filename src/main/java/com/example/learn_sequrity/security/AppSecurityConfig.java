package com.example.learn_sequrity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.learn_sequrity.security.AppUserRole.*;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/","index","/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
      UserDetails userStudent = User.builder()
                .username("yevhen")
                .password(passwordEncoder.encode("123321"))
                .authorities(STUDENT.getGrantAuthority())
                //.roles(STUDENT.name())
                .build();

      UserDetails userAdmin = User.builder()
              .username("yevhenii")
              .password(passwordEncoder.encode("123321"))
              .authorities(ADMIN.getGrantAuthority())
              //.roles(ADMIN.name())
              .build();

        UserDetails userAdminTrainee = User.builder()
                .username("jenyka")
                .password(passwordEncoder.encode("123321"))
                .authorities(ADMIN_TRAINEE.getGrantAuthority())
                //.roles(ADMIN_TRAINEE.name())
                .build();


      return new InMemoryUserDetailsManager(
              userStudent,
              userAdmin,
              userAdminTrainee
      );
    }
}
