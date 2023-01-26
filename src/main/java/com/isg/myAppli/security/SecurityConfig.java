package com.isg.myAppli.security;

import com.isg.myAppli.filter.CustomAuthentificationFilter;
import com.isg.myAppli.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(request-> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
            configuration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT"));
            configuration.setAllowedHeaders(List.of("*"));
            return configuration;
        });
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests().antMatchers("/login").permitAll();
        http.authorizeHttpRequests().antMatchers(POST,"/utilisateurs/add").permitAll();
        http.authorizeHttpRequests().antMatchers(GET,"/utilisateur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/utilisateur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/utilisateur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/produits/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/produits/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/produits/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/produits/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/laboratoire/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/laboratoire/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/laboratoire/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/laboratoire/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/categorie/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/categorie/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/categorie/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/categorie/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/fournisseur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/fournisseur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/fournisseur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/fournisseur/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/commande/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/commande/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/commande/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/commande/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/facture/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/facture/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/facture/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/facture/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(GET,"/magasin/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(POST,"/magasin/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(PUT,"/magasin/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers(DELETE,"/magasin/**").hasAnyAuthority("USER");
        http.authorizeHttpRequests().anyRequest().permitAll();
        http.addFilter(new CustomAuthentificationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
