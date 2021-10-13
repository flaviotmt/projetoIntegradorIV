package com.recomecar.projeto.recomecar.projeto;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.recomecar.projeto.recomecar.projeto.security.JWTAuthFilter;
import com.recomecar.projeto.recomecar.projeto.security.JWTValidateFilter;
import com.recomecar.projeto.recomecar.projeto.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailServiceImpl userService;
	private final PasswordEncoder passwordEncoder;
	private final DataSource dataSource;
	
	@Autowired
	public WebSecurityConfig(UserDetailServiceImpl userService, PasswordEncoder passwordEncoder, DataSource dataSource) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.dataSource = dataSource;
	}
	
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/", "/css/**", "/Imagens/**", "/cadastro-empresa", "/cadastro-imigrante").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.POST, "/loginpage").permitAll()
		.antMatchers(HttpMethod.POST, "/v1/candidate").permitAll()
		.antMatchers(HttpMethod.POST, "/v1/company").permitAll()
		.antMatchers("/v1/**").authenticated()
		.and()
		.addFilter(new JWTAuthFilter(authenticationManager()))
		.addFilter(new JWTValidateFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", corsConfiguration);
		
		return source;
	}

}
