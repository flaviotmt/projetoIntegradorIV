package mocks;

import com.recomecar.projeto.recomecar.projeto.viewmodel.CompanyVM;

public class CompanyVMMock {
	
	public static CompanyVM mock() {
		CompanyVM companyVM = new CompanyVM();
		companyVM.setAdressCompany("Rua B");
		companyVM.setCellphoneNumber("(yy) yyyyy-yyyy");
		companyVM.setCityCompany("Cidade");
		companyVM.setCnpj("00.000.000/0001-00");
		companyVM.setEmailCompany("empresa@empresa.com");
		companyVM.setFieldCompany("Campo");
		companyVM.setNameCompany("Companhia");
		companyVM.setSenha("456");
		companyVM.setStateCompany("Estado");
		companyVM.setZipCompany("yyyyy-yyy");
		
		return companyVM;
		
	}
	
	public static CompanyVM mockAtualizado() {
		CompanyVM companyVM = new CompanyVM();
		companyVM.setAdressCompany("Rua B 2");
		companyVM.setCellphoneNumber("(yy) yyyyy-yyyy 2");
		companyVM.setCityCompany("Cidade 2");
		companyVM.setCnpj("00.000.000/0001-00 2");
		companyVM.setEmailCompany("empresa@empresa.com");
		companyVM.setFieldCompany("Campo 2");
		companyVM.setNameCompany("Companhia 2");
		companyVM.setSenha("456");
		companyVM.setStateCompany("Estado 2");
		companyVM.setZipCompany("yyyyy-yyy 2");
		
		return companyVM;
		
	}

}
