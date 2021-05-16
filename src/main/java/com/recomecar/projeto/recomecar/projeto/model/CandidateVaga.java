package com.recomecar.projeto.recomecar.projeto.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.recomecar.projeto.recomecar.projeto.service.CandidateVagaKey;

@Entity
public class CandidateVaga {
			
	@EmbeddedId
	private CandidateVagaKey candidateVagaKey;
		
	private Short status;

	

	public CandidateVagaKey getCandidateVagaKey() {
		return candidateVagaKey;
	}

	public void setCandidateVagaKey(CandidateVagaKey candidateVagaKey) {
		this.candidateVagaKey = candidateVagaKey;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	
	

}
