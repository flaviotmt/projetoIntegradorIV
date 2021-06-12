package mocks;

import com.recomecar.projeto.recomecar.projeto.viewmodel.CurriculumVM;

public class CurriculumVMMock {
	
	public static CurriculumVM mock() {
		CurriculumVM curriculumVM = new CurriculumVM();
		curriculumVM.setAnoFormacao("12/2020");
		curriculumVM.setArea("Area");
		curriculumVM.setCountry("País");
		curriculumVM.setFormacao("Formação");
		curriculumVM.setInstituicao("Instituição");
		curriculumVM.setJobDesc("Cargo");
		curriculumVM.setLastEmp("Último Emprego");
		curriculumVM.setPretSalario("R$ XX.XXX,XX");
		
		return curriculumVM;
		
	}
	
	public static CurriculumVM mockAtualizado() {
		CurriculumVM curriculumVM = new CurriculumVM();
		curriculumVM.setAnoFormacao("12/2020 2");
		curriculumVM.setArea("Area 2");
		curriculumVM.setCountry("País 2");
		curriculumVM.setFormacao("Formação 2");
		curriculumVM.setInstituicao("Instituição 2");
		curriculumVM.setJobDesc("Cargo 2");
		curriculumVM.setLastEmp("Último Emprego 2");
		curriculumVM.setPretSalario("R$ XX.XXX,XX 2");
		
		return curriculumVM;
		
	}

}
