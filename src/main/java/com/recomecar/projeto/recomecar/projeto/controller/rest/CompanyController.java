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
import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.recomecar.projeto.recomecar.projeto.repository.AuthoritiesRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;
import com.recomecar.projeto.recomecar.projeto.repository.UserRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CompanyVM;

@RestController
@RequestMapping(value = "/v1/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
	
	private CompanyRepository repository;
	private UserRepository repositoryUser;
	private AuthoritiesRepository repositoryAuth;
	
	@Autowired
	public CompanyController(CompanyRepository repository, UserRepository repositoryUser, AuthoritiesRepository repositoryAuth) {
		this.repository = repository;
		this.repositoryUser = repositoryUser;
		this.repositoryAuth = repositoryAuth;
	}
	
	@PostMapping
	public ResponseEntity<CompanyVM> cadastrarCompany(@RequestBody final CompanyVM companyVM) {
		Company company = companyVM.toViewModel();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = new User();
		Authorities auth = new Authorities();
		user.setUsername(companyVM.getEmailCompany());
		user.setPassword(encoder.encode(companyVM.getSenha()));
		user.setEnabled(true);
				
		auth.setAuthority("EMP");
		auth.setUsername(companyVM.getEmailCompany());
		
		repositoryUser.save(user);
		repositoryAuth.save(auth);
		
		repository.save(company);
		
		return ResponseEntity.ok().body(companyVM);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyVM> buscarCompany(@PathVariable Long id) {
		Optional<Company> companyOp = repository.findById(id);
		
		if(companyOp.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		
		Company company = companyOp.get();
		
		CompanyVM companyVM = new CompanyVM();
		companyVM.setNameCompany(company.getNameCompany());
		companyVM.setCnpj(company.getCnpj());
		companyVM.setCellphoneNumber(company.getCellphoneNumber());
		companyVM.setFieldCompany(company.getFieldCompany());
		companyVM.setAdressCompany(company.getAdressCompany());
		companyVM.setCityCompany(company.getCityCompany());
		companyVM.setStateCompany(company.getStateCompany());
		companyVM.setZipCompany(company.getZipCompany());
		
		return ResponseEntity.ok().body(companyVM);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyVM> atualizarCompany(@PathVariable Long id, @RequestBody final CompanyVM companyVM) {
		Company company = repository.findById(id).get();
		company.setNameCompany(companyVM.getNameCompany());
		company.setCnpj(companyVM.getCnpj());
		company.setCellphoneNumber(companyVM.getCellphoneNumber());
		company.setFieldCompany(companyVM.getFieldCompany());
		company.setAdressCompany(companyVM.getAdressCompany());
		company.setCityCompany(companyVM.getCityCompany());
		company.setStateCompany(companyVM.getStateCompany());
		company.setZipCompany(companyVM.getZipCompany());
		
		repository.save(company);
		
		return ResponseEntity.ok().body(companyVM);
		
	}

}
