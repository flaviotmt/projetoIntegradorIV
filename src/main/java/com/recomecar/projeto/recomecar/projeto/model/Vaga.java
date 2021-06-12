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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividadesCargo == null) ? 0 : atividadesCargo.hashCode());
		result = prime * result + ((beneficiosCargo == null) ? 0 : beneficiosCargo.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cidadeCargo == null) ? 0 : cidadeCargo.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((estadoCargo == null) ? 0 : estadoCargo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((infoCargo == null) ? 0 : infoCargo.hashCode());
		result = prime * result + ((regimeContratacao == null) ? 0 : regimeContratacao.hashCode());
		result = prime * result + ((requisistosCargo == null) ? 0 : requisistosCargo.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		Vaga other = (Vaga) obj;
		if (atividadesCargo == null) {
			if (other.atividadesCargo != null)
				return false;
		} else if (!atividadesCargo.equals(other.atividadesCargo))
			return false;
		if (beneficiosCargo == null) {
			if (other.beneficiosCargo != null)
				return false;
		} else if (!beneficiosCargo.equals(other.beneficiosCargo))
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cidadeCargo == null) {
			if (other.cidadeCargo != null)
				return false;
		} else if (!cidadeCargo.equals(other.cidadeCargo))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (estadoCargo == null) {
			if (other.estadoCargo != null)
				return false;
		} else if (!estadoCargo.equals(other.estadoCargo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infoCargo == null) {
			if (other.infoCargo != null)
				return false;
		} else if (!infoCargo.equals(other.infoCargo))
			return false;
		if (regimeContratacao == null) {
			if (other.regimeContratacao != null)
				return false;
		} else if (!regimeContratacao.equals(other.regimeContratacao))
			return false;
		if (requisistosCargo == null) {
			if (other.requisistosCargo != null)
				return false;
		} else if (!requisistosCargo.equals(other.requisistosCargo))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	
	

	

}
