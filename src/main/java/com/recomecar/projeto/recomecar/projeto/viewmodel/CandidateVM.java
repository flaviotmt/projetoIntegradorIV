package com.recomecar.projeto.recomecar.projeto.viewmodel;

import com.recomecar.projeto.recomecar.projeto.model.Candidate;

import lombok.Data;

@Data
public class CandidateVM {
	
	private String emailCandidate;
	private String NameCandidate;
	private String cpf;
	private String cellphoneNumber;
	private String adressCandidate;
	private String cityCandidate;
	private String stateCandidate;
	private String zipCandidate;
	private String countryOrigin;
	private String languageOrigin;
	private String education;
	private String jobName;
	private String senha;
	
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
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


	public Candidate toViewModel() {
		Candidate candidate = new Candidate();
		
		candidate.setEmailCandidate(emailCandidate);
		candidate.setAdressCandidate(adressCandidate);
		candidate.setCellphoneNumber(cellphoneNumber);
		candidate.setCityCandidate(cityCandidate);
		candidate.setCountryOrigin(countryOrigin);
		candidate.setEducation(education);
		candidate.setJobName(jobName);
		candidate.setZipCandidate(zipCandidate);
		candidate.setLanguageOrigin(languageOrigin);
		candidate.setEducation(education);
		candidate.setNameCandidate(NameCandidate);
		candidate.setCpf(cpf);
		candidate.setStateCandidate(stateCandidate);
		
		
		return candidate;
	}

}
