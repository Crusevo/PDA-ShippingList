package com.example.PDA.ShippingList.SpringSecurity;

import com.example.PDA.ShippingList.ExceptionHandler.CustomAccessDeniedHandler;
import com.example.PDA.ShippingList.PageController.HomePageController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService)
            throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and().build();

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/homePage/").authenticated()
                .requestMatchers("/accessDeniedPage/").authenticated()
                .requestMatchers("/logoutPage/").authenticated()
                .requestMatchers("/userPage/").hasAuthority("USER")
                .requestMatchers("/projectPage/").hasAuthority("ADMIN")
                .requestMatchers("/addItemToProject/").hasAuthority("USER")
                .and()
                .formLogin()
                .loginPage("/loginPage/")
                .permitAll()
                .defaultSuccessUrl("/homePage/", true)
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .logout()
                .logoutUrl("/logoutPage/")
                .logoutSuccessUrl("/loginPage/")
                .permitAll();


        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }





}


