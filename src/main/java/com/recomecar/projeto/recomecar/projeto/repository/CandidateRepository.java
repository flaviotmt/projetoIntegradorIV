package com.recomecar.projeto.recomecar.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	
	public Candidate findByEmailCandidate(String email);

}
