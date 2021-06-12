package com.recomecar.projeto.recomecar.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "curriculum")
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String area;
	private String pretSalario;
	private String lastEmp;
	private String country;
	private String jobDesc;
	private String formacao;
	private String instituicao;
	private String anoFormacao;
	
	@OneToOne
	private Candidate candidate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPretSalario() {
		return pretSalario;
	}

	public void setPretSalario(String pretSalario) {
		this.pretSalario = pretSalario;
	}

	public String getLastEmp() {
		return lastEmp;
	}

	public void setLastEmp(String lastEmp) {
		this.lastEmp = lastEmp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getAnoFormacao() {
		return anoFormacao;
	}

	public void setAnoFormacao(String anoFormacao) {
		this.anoFormacao = anoFormacao;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFormacao == null) ? 0 : anoFormacao.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((jobDesc == null) ? 0 : jobDesc.hashCode());
		result = prime * result + ((lastEmp == null) ? 0 : lastEmp.hashCode());
		result = prime * result + ((pretSalario == null) ? 0 : pretSalario.hashCode());
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
		Curriculum other = (Curriculum) obj;
		if (anoFormacao == null) {
			if (other.anoFormacao != null)
				return false;
		} else if (!anoFormacao.equals(other.anoFormacao))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (jobDesc == null) {
			if (other.jobDesc != null)
				return false;
		} else if (!jobDesc.equals(other.jobDesc))
			return false;
		if (lastEmp == null) {
			if (other.lastEmp != null)
				return false;
		} else if (!lastEmp.equals(other.lastEmp))
			return false;
		if (pretSalario == null) {
			if (other.pretSalario != null)
				return false;
		} else if (!pretSalario.equals(other.pretSalario))
			return false;
		return true;
	}

	
	
}
