package com.recomecar.projeto.recomecar.projeto.viewmodel;

import com.recomecar.projeto.recomecar.projeto.model.Company;

public class CompanyVM {

	private String emailCompany;	
	private String nameCompany;
	private String cnpj;
	private String cellphoneNumber;
	private String adressCompany;
	private String cityCompany;
	private String stateCompany;
	private String zipCompany;
	private String fieldCompany;
	private String senha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmailCompany() {
		return emailCompany;
	}
	public void setEmailCompany(String emailCompany) {
		this.emailCompany = emailCompany;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public String getAdressCompany() {
		return adressCompany;
	}
	public void setAdressCompany(String adressCompany) {
		this.adressCompany = adressCompany;
	}
	public String getCityCompany() {
		return cityCompany;
	}
	public void setCityCompany(String cityCompany) {
		this.cityCompany = cityCompany;
	}
	public String getStateCompany() {
		return stateCompany;
	}
	public void setStateCompany(String stateCompany) {
		this.stateCompany = stateCompany;
	}
	public String getZipCompany() {
		return zipCompany;
	}
	public void setZipCompany(String zipCompany) {
		this.zipCompany = zipCompany;
	}
	public String getFieldCompany() {
		return fieldCompany;
	}
	public void setFieldCompany(String fieldCompany) {
		this.fieldCompany = fieldCompany;
	}
	public Company toViewModel() {
		Company company = new Company();
		
		company.setAdressCompany(adressCompany);
		company.setCellphoneNumber(cellphoneNumber);
		company.setCityCompany(cityCompany);
		company.setCnpj(cnpj);
		company.setEmailCompany(emailCompany);
		company.setFieldCompany(fieldCompany);
		company.setNameCompany(nameCompany);
		company.setStateCompany(stateCompany);
		company.setZipCompany(zipCompany);
		
		return company;
	}
	
	

}
