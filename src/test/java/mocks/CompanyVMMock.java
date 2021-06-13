package mocks;

import com.recomecar.projeto.recomecar.projeto.viewmodel.CompanyVM;

public class CompanyVMMock {
	
	public static CompanyVM mock() {
		CompanyVM companyVM = new CompanyVM();
		companyVM.setAdressCompany("RuaB");
		companyVM.setCellphoneNumber("(yy)yyyyy-yyyy");
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
		companyVM.setAdressCompany("RuaB2");
		companyVM.setCellphoneNumber("(yy)yyyyy-yyyy2");
		companyVM.setCityCompany("Cidade2");
		companyVM.setCnpj("00.000.000/0001-002");
		companyVM.setEmailCompany("empresa@empresa.com");
		companyVM.setFieldCompany("Campo2");
		companyVM.setNameCompany("Companhia2");
		companyVM.setSenha("456");
		companyVM.setStateCompany("Estado2");
		companyVM.setZipCompany("yyyyy-yyy2");
		
		return companyVM;
		
	}

}
