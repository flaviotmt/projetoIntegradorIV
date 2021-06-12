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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressCompany == null) ? 0 : adressCompany.hashCode());
		result = prime * result + ((cellphoneNumber == null) ? 0 : cellphoneNumber.hashCode());
		result = prime * result + ((cityCompany == null) ? 0 : cityCompany.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((emailCompany == null) ? 0 : emailCompany.hashCode());
		result = prime * result + ((fieldCompany == null) ? 0 : fieldCompany.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
		result = prime * result + ((stateCompany == null) ? 0 : stateCompany.hashCode());
		result = prime * result + ((zipCompany == null) ? 0 : zipCompany.hashCode());
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
		Company other = (Company) obj;
		if (adressCompany == null) {
			if (other.adressCompany != null)
				return false;
		} else if (!adressCompany.equals(other.adressCompany))
			return false;
		if (cellphoneNumber == null) {
			if (other.cellphoneNumber != null)
				return false;
		} else if (!cellphoneNumber.equals(other.cellphoneNumber))
			return false;
		if (cityCompany == null) {
			if (other.cityCompany != null)
				return false;
		} else if (!cityCompany.equals(other.cityCompany))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (emailCompany == null) {
			if (other.emailCompany != null)
				return false;
		} else if (!emailCompany.equals(other.emailCompany))
			return false;
		if (fieldCompany == null) {
			if (other.fieldCompany != null)
				return false;
		} else if (!fieldCompany.equals(other.fieldCompany))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameCompany == null) {
			if (other.nameCompany != null)
				return false;
		} else if (!nameCompany.equals(other.nameCompany))
			return false;
		if (stateCompany == null) {
			if (other.stateCompany != null)
				return false;
		} else if (!stateCompany.equals(other.stateCompany))
			return false;
		if (zipCompany == null) {
			if (other.zipCompany != null)
				return false;
		} else if (!zipCompany.equals(other.zipCompany))
			return false;
		return true;
	}
	

	

	

}
