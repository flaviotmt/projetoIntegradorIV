package com.recomecar.projeto.recomecar.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.CandidateVaga;
import com.recomecar.projeto.recomecar.projeto.service.CandidateVagaKey;

public interface CandidateVagaRepository extends JpaRepository<CandidateVaga, CandidateVagaKey>{

}
