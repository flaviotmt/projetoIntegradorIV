package com.recomecar.projeto.recomecar.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emailCandidate")
	private String emailCandidate;
	
	@Column(name="NameCandidate")
	private String NameCandidate;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cellphoneNumber")
	private String cellphoneNumber;
	
	@Column(name="adressCandidate")
	private String adressCandidate;
	
	@Column(name="cityCandidate")
	private String cityCandidate;
	
	@Column(name="stateCandidate")
	private String stateCandidate;
	
	@Column(name="zipCandidate")
	private String zipCandidate;
	
	@Column(name="countryOrigin")
	private String countryOrigin;
	
	@Column(name="languageOrigin")
	private String languageOrigin;
	
	@Column(name="education")
	private String education;
	
	@Column(name="jobName")
	private String jobName;
	
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailCandidate() {
		return emailCandidate;
	}
	public void setEmailCandidate(String emailCandidate) {
		this.emailCandidate = emailCandidate;
	}
	public String getNameCandidate() {
		return NameCandidate;
	}
	public void setNameCandidate(String nameCandidate) {
		NameCandidate = nameCandidate;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public String getAdressCandidate() {
		return adressCandidate;
	}
	public void setAdressCandidate(String adressCandidate) {
		this.adressCandidate = adressCandidate;
	}
	public String getCityCandidate() {
		return cityCandidate;
	}
	public void setCityCandidate(String cityCandidate) {
		this.cityCandidate = cityCandidate;
	}
	public String getStateCandidate() {
		return stateCandidate;
	}
	public void setStateCandidate(String stateCandidate) {
		this.stateCandidate = stateCandidate;
	}
	public String getZipCandidate() {
		return zipCandidate;
	}
	public void setZipCandidate(String zipCandidate) {
		this.zipCandidate = zipCandidate;
	}
	public String getCountryOrigin() {
		return countryOrigin;
	}
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}
	public String getLanguageOrigin() {
		return languageOrigin;
	}
	public void setLanguageOrigin(String languageOrigin) {
		this.languageOrigin = languageOrigin;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
	
}
