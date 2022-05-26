package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

                /*.inMemoryAuthentication()
                .withUser("employee")
                .password("$2a$10$B/Pim1zTnN.0fw7Mr4kJYeQwv8hvbjJ85DtKKez2yVJhulywUez76")
                .roles("EMPLOYEE")
                .and()
                .withUser("admin")
                .password("$2a$10$B/Pim1zTnN.0fw7Mr4kJYeQwv8hvbjJ85DtKKez2yVJhulywUez76")
                .roles("ADMIN");*/
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//        .antMatchers("/**").permitAll()
//        .and().formLogin();


        // Example 1
        http.authorizeRequests()
                .antMatchers("/employee/fetchall").hasRole("ADMIN")
                .antMatchers("/employee/fetch/*").hasAnyRole("USER", "ADMIN")
                .antMatchers("/employee/*").permitAll()
                .and().formLogin();

        // Example 2

//        http.authorizeRequests()
//                .antMatchers("/employee/fetchall", "/employee/fetch/*").authenticated()
//                .and().formLogin();

        // Example 3

//        http.authorizeRequests()
//                .antMatchers(getSecureServiceList()).authenticated()
//                .and().formLogin();

    }


    private String[] getSecureServiceList() {
        InputStream fileStream = TypeReference.class.getResourceAsStream("/static/secureservice.json");
        ObjectMapper mapper = new ObjectMapper();
        List<String> urlsList = new ArrayList<>();
        try {
            urlsList = mapper.readValue(fileStream, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urlsList.toArray(String[]::new);
    }
}
