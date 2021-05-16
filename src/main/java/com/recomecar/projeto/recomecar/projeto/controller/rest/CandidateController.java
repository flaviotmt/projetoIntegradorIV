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
	
	@Autowired
	private CandidateRepository repository;
	
	@Autowired
	private UserRepository repositoryUser;
	
	@Autowired
	private AuthoritiesRepository repositoryAuth;
	
	@PostMapping
	public ResponseEntity<CandidateVM> listarCandidatos(@RequestBody final CandidateVM candidateVM) {
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
		candidateVM.setNameCandidate(candidate.getNameCandidate());
		candidateVM.setCpf(candidate.getCpf());
		candidateVM.setCellphoneNumber(candidate.getCellphoneNumber());
		candidateVM.setAdressCandidate(candidate.getAdressCandidate());
		candidateVM.setCityCandidate(candidate.getCityCandidate());
		candidateVM.setStateCandidate(candidate.getStateCandidate());
		candidateVM.setZipCandidate(candidate.getZipCandidate());
		candidateVM.setCountryOrigin(candidate.getCountryOrigin());
		candidateVM.setLanguageOrigin(candidate.getLanguageOrigin());
		
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
	
		repository.save(candidate);
		
		return ResponseEntity.ok().body(candidateVM);
	}
	
}
