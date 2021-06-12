package com.recomecar.projeto.recomecar.projeto.controller.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.recomecar.projeto.recomecar.projeto.model.Authorities;
import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.recomecar.projeto.recomecar.projeto.repository.AuthoritiesRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;
import com.recomecar.projeto.recomecar.projeto.repository.UserRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CompanyVM;

import mocks.AuthoritiesMock;
import mocks.CompanyMock;
import mocks.CompanyVMMock;
import mocks.UserMock;

@ExtendWith(MockitoExtension.class)
class CompanyControllerTest {
	
	@Mock
	private CompanyRepository repository;
	
	@Mock
	private UserRepository repositoryUser;
	
	@Mock
	private AuthoritiesRepository repositoryAuth;
	
	@InjectMocks
	private CompanyController companyController;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void deveCadastarEmpresa() {
		CompanyVM companyVMMock = CompanyVMMock.mock();
		
		Company companyEsperado = CompanyMock.mock();
		companyEsperado.setId(null);
		Authorities authEsperado = AuthoritiesMock.mockCompany();
		User userEsperado = UserMock.mockCompany();
		
		when(repository.save(eq(companyEsperado))).thenReturn(companyEsperado);
		when(repositoryUser.save(eq(userEsperado))).thenReturn(userEsperado);
		when(repositoryAuth.save(eq(authEsperado))).thenReturn(authEsperado);
	
		ResponseEntity<CompanyVM> resposta = companyController.cadastrarCompany(companyVMMock);
		
		Assert.assertEquals(companyVMMock, resposta.getBody());
	}
	
	@Test
	void deveBuscarEmpresaQuandoCompanyEncontrado() {
		Optional<Company> companyOptionalMock = Optional.of(CompanyMock.mock());
		
		CompanyVM companyVMEsperado = CompanyVMMock.mock();
		companyVMEsperado.setSenha(null);
		companyVMEsperado.setEmailCompany(null);
		
		when(repository.findById(2L)).thenReturn(companyOptionalMock);
		
		ResponseEntity<CompanyVM> resposta = companyController.buscarCompany(2L);
		
		Assert.assertEquals(companyVMEsperado, resposta.getBody());
	}
	
	@Test
	void deveBuscarEmpresaQuandoCompanyNaoEncontrado() {
		when(repository.findById(2L)).thenReturn(Optional.empty());
		
		ResponseEntity<CompanyVM> resposta = companyController.buscarCompany(2L);
		
		Assert.assertEquals(null, resposta.getBody());		
	}
	
	@Test
	void deveAtualizarCandidatos() {
		CompanyVM companyVMMock = CompanyVMMock.mockAtualizado();
		
		Optional<Company> companyOptionalMock = Optional.of(CompanyMock.mock());
		when(repository.findById(2L)).thenReturn(companyOptionalMock);
		
		Company companyEsperado = CompanyMock.mockAtualizado();
		
		when(repository.save(eq(companyEsperado))).thenReturn(companyEsperado);
		
		ResponseEntity<CompanyVM> resposta = companyController.atualizarCompany(2L, companyVMMock);
		
		Assert.assertEquals(companyVMMock, resposta.getBody());
		
	}
}
