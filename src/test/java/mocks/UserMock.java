package mocks;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.recomecar.projeto.recomecar.projeto.model.User;

public class UserMock {
	
	public static User mockCandidate() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = new User();
		user.setEnabled(true);
		user.setUsername("email@email.com");
		user.setPassword(encoder.encode("123"));
		
		return user;
		
	}
	
	public static User mockCompany() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = new User();
		user.setEnabled(true);
		user.setUsername("empresa@empresa.com");
		user.setPassword(encoder.encode("456"));
		
		return user;
		
	}

}
