package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Candidate;

public class CandidateMock {
	
	public static Candidate mock() {
		Candidate candidate = new Candidate();
		candidate.setAdressCandidate("Rua A");
		candidate.setCellphoneNumber("(xx) xxxx-xxxx");
		candidate.setCityCandidate("Cidade");
		candidate.setCountryOrigin("País");
		candidate.setCpf("xxx.xxx.xxx-xx");
		candidate.setEducation("Educação");
		candidate.setEmailCandidate("email@email.com");
		candidate.setId(5L);
		candidate.setJobName("Cargo");
		candidate.setLanguageOrigin("Lingua");
		candidate.setNameCandidate("Candidato");
		candidate.setStateCandidate("Estado");
		candidate.setZipCandidate("xxxxx-xxx");
		
		return candidate;
		
	}
	
	public static Candidate mockAtualizado() {
		Candidate candidate = new Candidate();
		candidate.setAdressCandidate("Rua A 2");
		candidate.setCellphoneNumber("(xx) xxxx-xxxx 2");
		candidate.setCityCandidate("Cidade 2");
		candidate.setCountryOrigin("País 2");
		candidate.setCpf("xxx.xxx.xxx-xx 2");
		candidate.setEducation("Educação 2");
		candidate.setEmailCandidate("email@email.com");
		candidate.setId(5L);
		candidate.setJobName("Cargo 2");
		candidate.setLanguageOrigin("Lingua 2");
		candidate.setNameCandidate("Candidato 2");
		candidate.setStateCandidate("Estado 2");
		candidate.setZipCandidate("xxxxx-xxx 2");
		
		return candidate;
		
	}

}
