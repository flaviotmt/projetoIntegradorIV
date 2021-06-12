package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Curriculum;

public class CurriculumMock {
	
	public static Curriculum mock() {
		Curriculum curriculum = new Curriculum();
		curriculum.setAnoFormacao("12/2020");
		curriculum.setArea("Area");
		curriculum.setCountry("País");
		curriculum.setCandidate(CandidateMock.mock());
		curriculum.setFormacao("Formação");
		curriculum.setId(3L);
		curriculum.setInstituicao("Instituição");
		curriculum.setJobDesc("Cargo");
		curriculum.setLastEmp("Último Emprego");
		curriculum.setPretSalario("R$ XX.XXX,XX");
		
		
		return curriculum;
				
	}
	
	public static Curriculum mockAtualizado() {
		Curriculum curriculum = new Curriculum();
		curriculum.setAnoFormacao("12/2020 2");
		curriculum.setArea("Area 2");
		curriculum.setCountry("País 2");
		curriculum.setCandidate(CandidateMock.mock());
		curriculum.setFormacao("Formação 2");
		curriculum.setId(3L);
		curriculum.setInstituicao("Instituição 2");
		curriculum.setJobDesc("Cargo 2");
		curriculum.setLastEmp("Último Emprego 2");
		curriculum.setPretSalario("R$ XX.XXX,XX 2");
		
		
		return curriculum;
				
	}
	
	

}
