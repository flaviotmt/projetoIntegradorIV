package com.recomecar.projeto.recomecar.projeto.service;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CandidateVagaKey implements Serializable {
	
	private Long id_vaga;
	private Long id_candidate;
	
	public CandidateVagaKey() {

	}
	
	public CandidateVagaKey(Long id_vaga, Long id_candidate) {
		this.id_vaga = id_vaga;
		this.id_candidate = id_candidate;
	}

	public Long getId_vaga() {
		return id_vaga;
	}

	public void setId_vaga(Long id_vaga) {
		this.id_vaga = id_vaga;
	}

	public Long getId_candidate() {
		return id_candidate;
	}

	public void setId_candidate(Long id_candidate) {
		this.id_candidate = id_candidate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_candidate == null) ? 0 : id_candidate.hashCode());
		result = prime * result + ((id_vaga == null) ? 0 : id_vaga.hashCode());
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
		CandidateVagaKey other = (CandidateVagaKey) obj;
		if (id_candidate == null) {
			if (other.id_candidate != null)
				return false;
		} else if (!id_candidate.equals(other.id_candidate))
			return false;
		if (id_vaga == null) {
			if (other.id_vaga != null)
				return false;
		} else if (!id_vaga.equals(other.id_vaga))
			return false;
		return true;
	}
	
	

}
