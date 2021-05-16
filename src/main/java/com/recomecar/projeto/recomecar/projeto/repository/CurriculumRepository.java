package com.recomecar.projeto.recomecar.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long>{
	
	public Optional<Curriculum> findByCandidate(Candidate candidate);

}
