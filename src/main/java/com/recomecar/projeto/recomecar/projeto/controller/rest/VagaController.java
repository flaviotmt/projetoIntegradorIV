package com.recomecar.projeto.recomecar.projeto.controller.rest;

import java.util.ArrayList;
import java.util.List;
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

import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.Vaga;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;
import com.recomecar.projeto.recomecar.projeto.repository.VagasRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.VagaVM;

@RestController
@RequestMapping(value = "/v1/vaga", produces = MediaType.APPLICATION_JSON_VALUE)
public class VagaController {
	
	private VagasRepository repository;
	private CompanyRepository repositoryCompany;
	
	@Autowired
	public VagaController(VagasRepository repository, CompanyRepository repositoryCompany) {
		this.repository = repository;
		this.repositoryCompany = repositoryCompany;
		
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<VagaVM> cadastrarVaga(@PathVariable Long id, @RequestBody VagaVM vagaVM) {
		Vaga vaga = vagaVM.toViewModel();
		
		Company company = repositoryCompany.findById(id).get();
		vaga.setCompany(company);
			
		repository.save(vaga);
		
		return ResponseEntity.ok().body(vagaVM);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VagaVM> atualizarVaga(@PathVariable Long id, @RequestBody VagaVM vagaVM) {
		Optional<Vaga> vagaOp = repository.findById(id);
		
		Vaga vaga = vagaOp.get();
		vaga.setCargo(vagaVM.getCargo());
		vaga.setSalario(vagaVM.getSalario());
		vaga.setRegimeContratacao(vagaVM.getRegimeContratacao());
		vaga.setEstadoCargo(vagaVM.getEstadoCargo());
		vaga.setCidadeCargo(vagaVM.getCidadeCargo());
		vaga.setDataInicio(vagaVM.getDataInicio());
		vaga.setDataFim(vagaVM.getDataFim());
		vaga.setAtividadesCargo(vagaVM.getAtividadesCargo());
		vaga.setBeneficiosCargo(vagaVM.getBeneficiosCargo());
		vaga.setRequisistosCargo(vagaVM.getRequisistosCargo());
		vaga.setInfoCargo(vagaVM.getInfoCargo());
		
		repository.save(vaga);

		return ResponseEntity.ok().body(vagaVM);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VagaVM> buscarVaga(@PathVariable Long id) {
		Optional<Vaga> vagaOp = repository.findById(id);
		
		if(vagaOp.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		
		Vaga vaga = vagaOp.get();
		VagaVM vagaVM = new VagaVM();
		vagaVM.setCargo(vaga.getCargo());
		vagaVM.setSalario(vaga.getSalario());
		vagaVM.setRegimeContratacao(vaga.getRegimeContratacao());
		vagaVM.setEstadoCargo(vaga.getEstadoCargo());
		vagaVM.setCidadeCargo(vaga.getCidadeCargo());
		vagaVM.setDataInicio(vaga.getDataInicio());
		vagaVM.setDataFim(vaga.getDataFim());
		vagaVM.setAtividadesCargo(vaga.getAtividadesCargo());
		vagaVM.setBeneficiosCargo(vaga.getBeneficiosCargo());
		vagaVM.setRequisistosCargo(vaga.getRequisistosCargo());
		vagaVM.setInfoCargo(vaga.getInfoCargo());
		
		
		return ResponseEntity.ok().body(vagaVM);	
	}
	
	
	@GetMapping
	public ResponseEntity<List<VagaVM>> buscarVagas() {

		List<Vaga> vagas = repository.findAll();
		List<VagaVM> vagasVM = new ArrayList<VagaVM>();
		
		for(Vaga vaga : vagas) {
			VagaVM vagaVM = new VagaVM();
			vagaVM.setCargo(vaga.getCargo());
			vagaVM.setSalario(vaga.getSalario());
			vagaVM.setRegimeContratacao(vaga.getRegimeContratacao());
			vagaVM.setEstadoCargo(vaga.getEstadoCargo());
			vagaVM.setCidadeCargo(vaga.getCidadeCargo());
			vagaVM.setDataInicio(vaga.getDataInicio());
			vagaVM.setDataFim(vaga.getDataFim());
			vagaVM.setAtividadesCargo(vaga.getAtividadesCargo());
			vagaVM.setBeneficiosCargo(vaga.getBeneficiosCargo());
			vagaVM.setRequisistosCargo(vaga.getRequisistosCargo());
			vagaVM.setInfoCargo(vaga.getInfoCargo());
			vagaVM.setNomeEmpresa(vaga.getCompany().getNameCompany());
			vagaVM.setId(vaga.getId());
			
			vagasVM.add(vagaVM);
		}
		
		return ResponseEntity.ok().body(vagasVM);	
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<List<VagaVM>> buscarVagasEmpresa(@PathVariable Long id) {
		Company company = repositoryCompany.findById(id).get();
		Optional<List<Vaga>> vagaOp = repository.findByCompany(company);
		
		
		if(vagaOp.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		
		List<Vaga> vagas = vagaOp.get();
		List<VagaVM> vagasVM = new ArrayList<VagaVM>();
		
		for(Vaga vaga: vagas) {
			VagaVM vagaVM = new VagaVM();
			vagaVM.setCargo(vaga.getCargo());
			vagaVM.setSalario(vaga.getSalario());
			vagaVM.setRegimeContratacao(vaga.getRegimeContratacao());
			vagaVM.setEstadoCargo(vaga.getEstadoCargo());
			vagaVM.setCidadeCargo(vaga.getCidadeCargo());
			vagaVM.setDataInicio(vaga.getDataInicio());
			vagaVM.setDataFim(vaga.getDataFim());
			vagaVM.setAtividadesCargo(vaga.getAtividadesCargo());
			vagaVM.setBeneficiosCargo(vaga.getBeneficiosCargo());
			vagaVM.setRequisistosCargo(vaga.getRequisistosCargo());
			vagaVM.setInfoCargo(vaga.getInfoCargo());
			vagaVM.setNomeEmpresa(vaga.getCompany().getNameCompany());
			vagaVM.setId(vaga.getId());
			
			vagasVM.add(vagaVM);
		}
		
		
		return ResponseEntity.ok().body(vagasVM);	
	}
	

}
