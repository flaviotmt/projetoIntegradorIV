package mocks;

import com.recomecar.projeto.recomecar.projeto.viewmodel.CurriculumVM;

public class CurriculumVMMock {
	
	public static CurriculumVM mock() {
		CurriculumVM curriculumVM = new CurriculumVM();
		curriculumVM.setAnoFormacao("12/2020");
		curriculumVM.setArea("Area");
		curriculumVM.setCountry("Pais");
		curriculumVM.setFormacao("Formacao");
		curriculumVM.setInstituicao("Instituicao");
		curriculumVM.setJobDesc("Cargo");
		curriculumVM.setLastEmp("Ultimo Emprego");
		curriculumVM.setPretSalario("R$ XX.XXX,XX");
		
		return curriculumVM;
		
	}
	
	public static CurriculumVM mockAtualizado() {
		CurriculumVM curriculumVM = new CurriculumVM();
		curriculumVM.setAnoFormacao("12/2020 2");
		curriculumVM.setArea("Area 2");
		curriculumVM.setCountry("Pais 2");
		curriculumVM.setFormacao("Formacao 2");
		curriculumVM.setInstituicao("Instituicao 2");
		curriculumVM.setJobDesc("Cargo 2");
		curriculumVM.setLastEmp("Ultimo Emprego 2");
		curriculumVM.setPretSalario("R$ XX.XXX,XX 2");
		
		return curriculumVM;
		
	}

}
