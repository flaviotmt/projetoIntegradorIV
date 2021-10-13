package com.recomecar.projeto.recomecar.projeto.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recomecar.projeto.recomecar.projeto.data.UserDetailData;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter{
	public static final int TOKEN_EXP = 600000;
	public static final String TOKEN_PASSWORD = "26de4b7b-2012-4aa9-a508-acc9eea87428";
	
	private final AuthenticationManager authenticationManager;
	
	public JWTAuthFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException {
		try {
			User user =  new ObjectMapper().readValue(request.getInputStream(), User.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getUsername(),
					user.getPassword(),
					new ArrayList<>()
					));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuário", e);
		}
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain, 
			Authentication authResult) throws IOException, ServletException{
		
		UserDetailData userDetailData = (UserDetailData) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(userDetailData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXP))
				.sign(Algorithm.HMAC512(TOKEN_PASSWORD));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
