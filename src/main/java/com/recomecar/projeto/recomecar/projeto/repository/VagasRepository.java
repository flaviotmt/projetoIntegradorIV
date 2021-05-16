package com.recomecar.projeto.recomecar.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.Vaga;

public interface VagasRepository extends JpaRepository<Vaga, Long>{
	public Optional<List<Vaga>> findByCompany(Company company);

}
