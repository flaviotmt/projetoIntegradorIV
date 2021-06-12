package mocks;

import com.recomecar.projeto.recomecar.projeto.model.Company;

public class CompanyMock {
	
	public static Company mock() {
		Company company = new Company();
		company.setAdressCompany("Rua B");
		company.setCellphoneNumber("(yy) yyyyy-yyyy");
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
		company.setAdressCompany("Rua B 2");
		company.setCellphoneNumber("(yy) yyyyy-yyyy 2");
		company.setCityCompany("Cidade 2");
		company.setCnpj("00.000.000/0001-00 2");
		company.setEmailCompany("empresa@empresa.com");
		company.setFieldCompany("Campo 2");
		company.setId(2L);
		company.setNameCompany("Companhia 2");
		company.setStateCompany("Estado 2");
		company.setZipCompany("yyyyy-yyy 2");
		
		return company;
	}

}
