package com.recomecar.projeto.recomecar.projeto.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recomecar.projeto.recomecar.projeto.model.CandidateVaga;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateVagaRepository;
import com.recomecar.projeto.recomecar.projeto.service.CandidateVagaKey;

@RestController
@RequestMapping(value = "/v1/candidatar", produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateVagaController {
	
	@Autowired
	private CandidateVagaRepository repository;
	
	
	@PostMapping("/{id_vaga}/{id_candidato}")
	public ResponseEntity<CandidateVaga> cadastrarCandidato(@PathVariable Long id_vaga, @PathVariable Long id_candidato) {
		
		CandidateVaga candidateVaga = new CandidateVaga();
		CandidateVagaKey candidateVagaKey = new CandidateVagaKey(id_vaga, id_candidato);
		
		candidateVaga.setCandidateVagaKey(candidateVagaKey);
		candidateVaga.setStatus((short) 1);
		
		repository.save(candidateVaga);
		
		return ResponseEntity.ok().body(candidateVaga);
	}

}
