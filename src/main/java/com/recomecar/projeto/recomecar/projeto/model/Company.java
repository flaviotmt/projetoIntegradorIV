package com.recomecar.projeto.recomecar.projeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emailCompany")
	private String emailCompany;
	
	@Column(name="nameCompany")
	private String nameCompany;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="cellphoneNumber")
	private String cellphoneNumber;
	
	@Column(name="adressCompany")
	private String adressCompany;
	
	@Column(name="cityCompany")
	private String cityCompany;
	
	@Column(name="stateCompany")
	private String stateCompany;
	
	@Column(name="zipCompany")
	private String zipCompany;
	
	@Column(name="fieldCompany")
	private String fieldCompany;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Vaga> vagas;

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	

	

}
