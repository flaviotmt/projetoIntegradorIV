package com.recomecar.projeto.recomecar.projeto.controller.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recomecar.projeto.recomecar.projeto.model.Authorities;
import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.recomecar.projeto.recomecar.projeto.repository.AuthoritiesRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.UserRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CandidateVM;

@RestController
@RequestMapping(value = "/v1/candidate", produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {
	
	private CandidateRepository repository;
	private UserRepository repositoryUser;
	private AuthoritiesRepository repositoryAuth;
	
	@Autowired
	public CandidateController(CandidateRepository repository, UserRepository repositoryUser, AuthoritiesRepository repositoryAuth ) {
		this.repository = repository;
		this.repositoryUser = repositoryUser;
		this.repositoryAuth = repositoryAuth;
	}
	
	@PostMapping
	public ResponseEntity<CandidateVM> cadastrarCandidatos(@RequestBody final CandidateVM candidateVM) {
		Candidate candidate = candidateVM.toViewModel();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = new User();
		Authorities auth = new Authorities();
		user.setUsername(candidateVM.getEmailCandidate());
		user.setEnabled(true);
		user.setPassword(encoder.encode(candidateVM.getSenha()));
		
		auth.setAuthority("IMI");
		auth.setUsername(candidateVM.getEmailCandidate());
		
		repositoryUser.save(user);
		repositoryAuth.save(auth);
		
		repository.save(candidate);
		
		return ResponseEntity.ok().body(candidateVM);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CandidateVM> buscarCandidate(@PathVariable Long id){
		Optional<Candidate> candidateOptional = repository.findById(id);
		
		if(candidateOptional.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		
		Candidate candidate = candidateOptional.get();
		
		CandidateVM candidateVM = new CandidateVM();
		candidateVM.setAdressCandidate(candidate.getAdressCandidate());
		candidateVM.setCellphoneNumber(candidate.getCellphoneNumber());
		candidateVM.setCityCandidate(candidate.getCityCandidate());
		candidateVM.setCountryOrigin(candidate.getCountryOrigin());
		candidateVM.setCpf(candidate.getCpf());
		candidateVM.setEducation(candidate.getEducation());
		candidateVM.setJobName(candidate.getJobName());
		candidateVM.setLanguageOrigin(candidate.getLanguageOrigin());
		candidateVM.setNameCandidate(candidate.getNameCandidate());	
		candidateVM.setStateCandidate(candidate.getStateCandidate());
		candidateVM.setZipCandidate(candidate.getZipCandidate());
		
		
		
		return ResponseEntity.ok().body(candidateVM);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CandidateVM> atualizarCandidate(@PathVariable Long id, @RequestBody final CandidateVM candidateVM) {
		Candidate candidate = repository.findById(id).get();
		candidate.setNameCandidate(candidateVM.getNameCandidate());
		candidate.setCpf(candidateVM.getCpf());
		candidate.setCellphoneNumber(candidateVM.getCellphoneNumber());
		candidate.setAdressCandidate(candidateVM.getAdressCandidate());
		candidate.setCityCandidate(candidateVM.getCityCandidate());
		candidate.setStateCandidate(candidateVM.getStateCandidate());
		candidate.setZipCandidate(candidateVM.getZipCandidate());
		candidate.setCountryOrigin(candidateVM.getCountryOrigin());
		candidate.setLanguageOrigin(candidateVM.getLanguageOrigin());
		candidate.setEducation(candidateVM.getEducation());
		candidate.setJobName(candidateVM.getJobName());
	
		repository.save(candidate);
		
		return ResponseEntity.ok().body(candidateVM);
	}
	
}
