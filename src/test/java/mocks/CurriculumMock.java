package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Curriculum;

public class CurriculumMock {
	
	public static Curriculum mock() {
		Curriculum curriculum = new Curriculum();
		curriculum.setAnoFormacao("12/2020");
		curriculum.setArea("Area");
		curriculum.setCountry("Pais");
		curriculum.setCandidate(CandidateMock.mock());
		curriculum.setFormacao("Formacao");
		curriculum.setId(3L);
		curriculum.setInstituicao("Instituicao");
		curriculum.setJobDesc("Cargo");
		curriculum.setLastEmp("Ultimo Emprego");
		curriculum.setPretSalario("R$ XX.XXX,XX");
		
		
		return curriculum;
				
	}
	
	public static Curriculum mockAtualizado() {
		Curriculum curriculum = new Curriculum();
		curriculum.setAnoFormacao("12/2020 2");
		curriculum.setArea("Area 2");
		curriculum.setCountry("Pais 2");
		curriculum.setCandidate(CandidateMock.mock());
		curriculum.setFormacao("Formacao 2");
		curriculum.setId(3L);
		curriculum.setInstituicao("Instituicao 2");
		curriculum.setJobDesc("Cargo 2");
		curriculum.setLastEmp("Ultimo Emprego 2");
		curriculum.setPretSalario("R$ XX.XXX,XX 2");
		
		
		return curriculum;
				
	}
	
	

}
