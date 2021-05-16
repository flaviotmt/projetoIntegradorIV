package com.recomecar.projeto.recomecar.projeto.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vaga")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cargo;
	private String salario;
	private String regimeContratacao;
	private String estadoCargo;
	private String cidadeCargo;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String atividadesCargo;
	private String beneficiosCargo;
	private String requisistosCargo;
	private String infoCargo;
	
	@ManyToOne
	private Company company;
	
	
	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getRegimeContratacao() {
		return regimeContratacao;
	}

	public void setRegimeContratacao(String regimeContratacao) {
		this.regimeContratacao = regimeContratacao;
	}

	public String getEstadoCargo() {
		return estadoCargo;
	}

	public void setEstadoCargo(String estadoCargo) {
		this.estadoCargo = estadoCargo;
	}

	
	public String getCidadeCargo() {
		return cidadeCargo;
	}

	public void setCidadeCargo(String cidadeCargo) {
		this.cidadeCargo = cidadeCargo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getAtividadesCargo() {
		return atividadesCargo;
	}

	public void setAtividadesCargo(String atividadesCargo) {
		this.atividadesCargo = atividadesCargo;
	}

	public String getBeneficiosCargo() {
		return beneficiosCargo;
	}

	public void setBeneficiosCargo(String beneficiosCargo) {
		this.beneficiosCargo = beneficiosCargo;
	}

	public String getRequisistosCargo() {
		return requisistosCargo;
	}

	public void setRequisistosCargo(String requisistosCargo) {
		this.requisistosCargo = requisistosCargo;
	}

	public String getInfoCargo() {
		return infoCargo;
	}

	public void setInfoCargo(String infoCargo) {
		this.infoCargo = infoCargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

}
