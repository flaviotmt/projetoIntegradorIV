package com.recomecar.projeto.recomecar.projeto.controller.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.Curriculum;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CurriculumRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CurriculumVM;

@RestController
@RequestMapping(value = "/v1/curriculum", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurriculumController {
	
	private CurriculumRepository curriculumRepository;
	private CandidateRepository candidateRepository;
	
	@Autowired
	public CurriculumController(CurriculumRepository curriculumRepository, CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
		this.curriculumRepository = curriculumRepository;
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<CurriculumVM> cadastrarCurriculo(@PathVariable Long id, @RequestBody CurriculumVM curriculumVM){
		Curriculum curriculum = curriculumVM.toViewModel();
	
		Candidate candidate = candidateRepository.findById(id).get();
		curriculum.setCandidate(candidate);

		curriculumRepository.save(curriculum);
		
		return ResponseEntity.ok().body(curriculumVM);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CurriculumVM> atualizarCurriculo(@PathVariable Long id, @RequestBody CurriculumVM curriculumVM){
		Candidate candidate = candidateRepository.findById(id).get();
				
		Curriculum curriculum = curriculumRepository.findByCandidate(candidate).get();
		curriculum.setAnoFormacao(curriculumVM.getAnoFormacao());
		curriculum.setArea(curriculumVM.getArea());
		curriculum.setCountry(curriculumVM.getCountry());
		curriculum.setFormacao(curriculumVM.getFormacao());
		curriculum.setInstituicao(curriculumVM.getInstituicao());
		curriculum.setJobDesc(curriculumVM.getJobDesc());
		curriculum.setLastEmp(curriculumVM.getLastEmp());
		curriculum.setPretSalario(curriculumVM.getPretSalario());
		
		curriculumRepository.save(curriculum);

		return ResponseEntity.ok().body(curriculumVM);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CurriculumVM> buscarCurriculo(@PathVariable Long id){
		Candidate candidate = candidateRepository.findById(id).get();
		Optional<Curriculum> curriculumOp = curriculumRepository.findByCandidate(candidate);
		
		if(curriculumOp.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		
		Curriculum curriculum = (Curriculum) curriculumOp.get();
		
		CurriculumVM curriculumVM = new CurriculumVM();
		curriculumVM.setAnoFormacao(curriculum.getAnoFormacao());
		curriculumVM.setArea(curriculum.getArea());
		curriculumVM.setCountry(curriculum.getCountry());
		curriculumVM.setFormacao(curriculum.getFormacao());
		curriculumVM.setInstituicao(curriculum.getInstituicao());
		curriculumVM.setJobDesc(curriculum.getJobDesc());
		curriculumVM.setLastEmp(curriculum.getLastEmp());
		curriculumVM.setPretSalario(curriculum.getPretSalario());
		
		return ResponseEntity.ok().body(curriculumVM);
	}

}
