package com.recomecar.projeto.recomecar.projeto.viewmodel;

import com.recomecar.projeto.recomecar.projeto.model.Curriculum;

public class CurriculumVM {

	private String area;
	private String pretSalario;
	private String lastEmp;
	private String country;
	private String jobDesc;
	private String formacao;
	private String instituicao;
	private String anoFormacao;
	
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
	public Curriculum toViewModel() {
		Curriculum curriculum = new Curriculum();
		curriculum.setAnoFormacao(anoFormacao);
		curriculum.setArea(area);
		curriculum.setCountry(country);
		curriculum.setFormacao(anoFormacao);
		curriculum.setInstituicao(instituicao);
		curriculum.setJobDesc(jobDesc);
		curriculum.setLastEmp(lastEmp);
		curriculum.setPretSalario(pretSalario);

		return curriculum;
	}
	
	
}
