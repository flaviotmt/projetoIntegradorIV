package com.recomecar.projeto.recomecar.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.recomecar.projeto.recomecar.projeto.data.UserDetailData;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.recomecar.projeto.recomecar.projeto.repository.UserRepository;

@Component
public class UserDetailServiceImpl implements UserDetailsService{
	
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findById(username);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("Usuario [" + username + "] não encontrado");
		}
		
		return new UserDetailData(user);
	}

}
