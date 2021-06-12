package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Authorities;

public class AuthoritiesMock {
	
	public static Authorities mockCandidate() {
		Authorities auth = new Authorities();
		auth.setAuthority("IMI");
		auth.setUsername("email@email.com");
		
		return auth;
		
	}
	
	public static Authorities mockCompany() {
		Authorities auth = new Authorities();
		auth.setAuthority("EMP");
		auth.setUsername("empresa@empresa.com");
		
		return auth;
		
	}

}
