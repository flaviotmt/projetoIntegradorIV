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

}
