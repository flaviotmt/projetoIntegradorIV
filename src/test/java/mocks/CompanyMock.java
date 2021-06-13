package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Company;

public class CompanyMock {
	
	public static Company mock() {
		Company company = new Company();
		company.setAdressCompany("RuaB");
		company.setCellphoneNumber("(yy)yyyyy-yyyy");
		company.setCityCompany("Cidade");
		company.setCnpj("00.000.000/0001-00");
		company.setEmailCompany("empresa@empresa.com");
		company.setFieldCompany("Campo");
		company.setId(2L);
		company.setNameCompany("Companhia");
		company.setStateCompany("Estado");
		company.setZipCompany("yyyyy-yyy");
		
		return company;
	}
	
	public static Company mockAtualizado() {
		Company company = new Company();
		company.setAdressCompany("RuaB2");
		company.setCellphoneNumber("(yy)yyyyy-yyyy2");
		company.setCityCompany("Cidade2");
		company.setCnpj("00.000.000/0001-002");
		company.setEmailCompany("empresa@empresa.com");
		company.setFieldCompany("Campo2");
		company.setId(2L);
		company.setNameCompany("Companhia2");
		company.setStateCompany("Estado2");
		company.setZipCompany("yyyyy-yyy2");
		
		return company;
	}

}
