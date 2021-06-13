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
import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.User;
import com.recomecar.projeto.recomecar.projeto.repository.AuthoritiesRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.UserRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CandidateVM;


import mocks.AuthoritiesMock;
import mocks.CandidateMock;
import mocks.CandidateVMMock;
import mocks.UserMock;

@RunWith(SpringRunner.class)
@WebMvcTest(CandidateController.class)
@ContextConfiguration(classes={Application.class})
public class CandidateControllerMVCTest {
	
	@MockBean
	private CandidateRepository repository;
	
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
		
	private static final String PATH = "/v1/candidate";
	
	@Test
	void simularCadastrarCandidato() throws Exception {
		CandidateVM candidateVMMock = CandidateVMMock.mock();
		
		Candidate candidateEsperado = CandidateMock.mock();
		candidateEsperado.setId(null);
		Authorities authEsperado = AuthoritiesMock.mockCandidate();
		User userEsperado = UserMock.mockCandidate();
		
		when(repository.save(eq(candidateEsperado))).thenReturn(candidateEsperado);
		when(repositoryUser.save(eq(userEsperado))).thenReturn(userEsperado);
		when(repositoryAuth.save(eq(authEsperado))).thenReturn(authEsperado);
		
		final MvcResult mvcResult = mvc.perform(post(PATH)
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(candidateVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(candidateVMMock), 
				mvcResult.getResponse().getContentAsString());	
	}
	

	@Test
	void simularBuscarCandidatosQuandoCandidateEncontrado() throws Exception {
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		CandidateVM candidateVMEsperado = CandidateVMMock.mock();
		candidateVMEsperado.setSenha(null);
		candidateVMEsperado.setEmailCandidate(null);
		
		when(repository.findById(5L)).thenReturn(candidateOptionalMock);
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(candidateVMEsperado), 
				mvcResult.getResponse().getContentAsString());	
	}
	
	@Test
	void simularBuscarCandidatosQuandoCandidatoNaoEncontrado() throws Exception {
		when(repository.findById(5L)).thenReturn(Optional.empty());
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
				
		Assert.assertTrue(mvcResult.getResponse().getContentAsString().isEmpty());	
	}
	
	@Test
	void simularAtualizarCandidatos() throws Exception {
		CandidateVM candidateVMMock = CandidateVMMock.mockAtualizado();
		
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		when(repository.findById(5L)).thenReturn(candidateOptionalMock);
		
		Candidate candidateEsperado = CandidateMock.mockAtualizado();
		
		when(repository.save(eq(candidateEsperado))).thenReturn(candidateEsperado);
		
		final MvcResult mvcResult = mvc.perform(put(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(candidateVMMock)))
				.andExpect(status().isOk()).andReturn();
				
		Assert.assertEquals(objectMapper.writeValueAsString(candidateVMMock), 
				mvcResult.getResponse().getContentAsString());		
	}

}
