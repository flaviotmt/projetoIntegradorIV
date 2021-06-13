package com.recomecar.projeto.recomecar.projeto.controller.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recomecar.projeto.recomecar.projeto.Application;
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

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
@ContextConfiguration(classes={Application.class})
public class CompanyControllerMVCTest {
	
	@MockBean
	private CompanyRepository repository;
	
	@MockBean
	private UserRepository repositoryUser;
	
	@MockBean
	private AuthoritiesRepository repositoryAuth;
		
	@MockBean
	private DataSource dataSource;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
		
	private static final String PATH = "/v1/company";
	
	@Test
	void simularCadastarEmpresa() throws Exception {
		CompanyVM companyVMMock = CompanyVMMock.mock();
		
		Company companyEsperado = CompanyMock.mock();
		companyEsperado.setId(null);
		Authorities authEsperado = AuthoritiesMock.mockCompany();
		User userEsperado = UserMock.mockCompany();
		
		when(repository.save(eq(companyEsperado))).thenReturn(companyEsperado);
		when(repositoryUser.save(eq(userEsperado))).thenReturn(userEsperado);
		when(repositoryAuth.save(eq(authEsperado))).thenReturn(authEsperado);
		
		final MvcResult mvcResult = mvc.perform(post(PATH)
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(companyVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(companyVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarEmpresaQuandoCompanyEncontrado() throws Exception {
		Optional<Company> companyOptionalMock = Optional.of(CompanyMock.mock());
		
		CompanyVM companyVMEsperado = CompanyVMMock.mock();
		companyVMEsperado.setSenha(null);
		companyVMEsperado.setEmailCompany(null);
		
		when(repository.findById(2L)).thenReturn(companyOptionalMock);
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(companyVMEsperado), 
				mvcResult.getResponse().getContentAsString());	
	}
	
	@Test
	void simularBuscarEmpresaQuandoCompanyNaoEncontrado() throws Exception {
		when(repository.findById(2L)).thenReturn(Optional.empty());
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
				
		Assert.assertTrue(mvcResult.getResponse().getContentAsString().isEmpty());
	}
	
	@Test
	void simularAtualizarCandidatos() throws Exception {
		CompanyVM companyVMMock = CompanyVMMock.mockAtualizado();
		
		Optional<Company> companyOptionalMock = Optional.of(CompanyMock.mock());
		when(repository.findById(2L)).thenReturn(companyOptionalMock);
		
		Company companyEsperado = CompanyMock.mockAtualizado();
		
		when(repository.save(eq(companyEsperado))).thenReturn(companyEsperado);
		
		final MvcResult mvcResult = mvc.perform(put(PATH+"/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(companyVMMock)))
				.andExpect(status().isOk()).andReturn();
				
		Assert.assertEquals(objectMapper.writeValueAsString(companyVMMock), 
				mvcResult.getResponse().getContentAsString());		
	}

}
