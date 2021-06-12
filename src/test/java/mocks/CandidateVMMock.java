package mocks;

import com.recomecar.projeto.recomecar.projeto.viewmodel.CandidateVM;

public class CandidateVMMock {
	
	public static CandidateVM mock() {
		CandidateVM candidateVM = new CandidateVM();
		candidateVM.setAdressCandidate("Rua A");
		candidateVM.setCellphoneNumber("(xx) xxxx-xxxx");
		candidateVM.setCityCandidate("Cidade");
		candidateVM.setCountryOrigin("País");
		candidateVM.setCpf("xxx.xxx.xxx-xx");
		candidateVM.setEducation("Educação");
		candidateVM.setEmailCandidate("email@email.com");
		candidateVM.setJobName("Cargo");
		candidateVM.setLanguageOrigin("Lingua");
		candidateVM.setNameCandidate("Candidato");
		candidateVM.setSenha("123");
		candidateVM.setStateCandidate("Estado");
		candidateVM.setZipCandidate("xxxxx-xxx");
		
		
		return candidateVM;
		
	}
	
	public static CandidateVM mockAtualizado() {
		CandidateVM candidateVM = new CandidateVM();
		candidateVM.setAdressCandidate("Rua A 2");
		candidateVM.setCellphoneNumber("(xx) xxxx-xxxx 2");
		candidateVM.setCityCandidate("Cidade 2");
		candidateVM.setCountryOrigin("País 2");
		candidateVM.setCpf("xxx.xxx.xxx-xx 2");
		candidateVM.setEducation("Educação 2");
		candidateVM.setEmailCandidate("email@email.com");
		candidateVM.setJobName("Cargo 2");
		candidateVM.setLanguageOrigin("Lingua 2");
		candidateVM.setNameCandidate("Candidato 2");
		candidateVM.setSenha("123");
		candidateVM.setStateCandidate("Estado 2");
		candidateVM.setZipCandidate("xxxxx-xxx 2");
		
		
		return candidateVM;
		
	}

}
