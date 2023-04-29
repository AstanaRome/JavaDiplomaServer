package com.diploma.config;


import com.diploma.services.auth.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("CLIENT", "DOCTOR", "ADMIN")
                .antMatchers("/users").hasAnyAuthority("ADMIN")
                .antMatchers("/doctors").hasAnyAuthority("ADMIN")
                .antMatchers("/records").hasAnyAuthority("ADMIN")
                .antMatchers("/roles}").hasAnyAuthority("ADMIN")
              //  .antMatchers("/records/{id}").hasAnyAuthority("ADMIN")
                .antMatchers("/users/{id}").hasAnyAuthority("ADMIN")
                .antMatchers("/doctors/{id}").hasAnyAuthority("ADMIN")
                .antMatchers("/roles/{id}").hasAnyAuthority("ADMIN")


                .antMatchers("/client/myrecords").hasAnyAuthority( "CLIENT")


//                .antMatchers("/delete/**").hasAuthority("ADMIN")

                //.antMatchers("/users/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403").and().httpBasic();
        http.cors().disable().csrf().disable();
        ;
    }
}