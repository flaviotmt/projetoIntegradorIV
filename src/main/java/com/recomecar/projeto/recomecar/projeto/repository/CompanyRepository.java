package com.recomecar.projeto.recomecar.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	public Company findByEmailCompany(String email);

}
