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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NameCandidate == null) ? 0 : NameCandidate.hashCode());
		result = prime * result + ((adressCandidate == null) ? 0 : adressCandidate.hashCode());
		result = prime * result + ((cellphoneNumber == null) ? 0 : cellphoneNumber.hashCode());
		result = prime * result + ((cityCandidate == null) ? 0 : cityCandidate.hashCode());
		result = prime * result + ((countryOrigin == null) ? 0 : countryOrigin.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((emailCandidate == null) ? 0 : emailCandidate.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result + ((languageOrigin == null) ? 0 : languageOrigin.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((stateCandidate == null) ? 0 : stateCandidate.hashCode());
		result = prime * result + ((zipCandidate == null) ? 0 : zipCandidate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateVM other = (CandidateVM) obj;
		if (NameCandidate == null) {
			if (other.NameCandidate != null)
				return false;
		} else if (!NameCandidate.equals(other.NameCandidate))
			return false;
		if (adressCandidate == null) {
			if (other.adressCandidate != null)
				return false;
		} else if (!adressCandidate.equals(other.adressCandidate))
			return false;
		if (cellphoneNumber == null) {
			if (other.cellphoneNumber != null)
				return false;
		} else if (!cellphoneNumber.equals(other.cellphoneNumber))
			return false;
		if (cityCandidate == null) {
			if (other.cityCandidate != null)
				return false;
		} else if (!cityCandidate.equals(other.cityCandidate))
			return false;
		if (countryOrigin == null) {
			if (other.countryOrigin != null)
				return false;
		} else if (!countryOrigin.equals(other.countryOrigin))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (emailCandidate == null) {
			if (other.emailCandidate != null)
				return false;
		} else if (!emailCandidate.equals(other.emailCandidate))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (languageOrigin == null) {
			if (other.languageOrigin != null)
				return false;
		} else if (!languageOrigin.equals(other.languageOrigin))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (stateCandidate == null) {
			if (other.stateCandidate != null)
				return false;
		} else if (!stateCandidate.equals(other.stateCandidate))
			return false;
		if (zipCandidate == null) {
			if (other.zipCandidate != null)
				return false;
		} else if (!zipCandidate.equals(other.zipCandidate))
			return false;
		return true;
	}
	
	

}
