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
import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.Curriculum;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CurriculumRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CurriculumVM;

import mocks.CandidateMock;
import mocks.CurriculumMock;
import mocks.CurriculumVMMock;

@RunWith(SpringRunner.class)
@WebMvcTest(CurriculumController.class)
@ContextConfiguration(classes={Application.class})
public class CurriculumControllerMVCTest {
	
	@MockBean
	private CurriculumRepository curriculumRepository;
	
	@MockBean
	private CandidateRepository candidateRepository;
		
	@MockBean
	private DataSource dataSource;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
		
	private static final String PATH = "/v1/curriculum";
	
	@Test
	void simularCadastarCurriculo() throws Exception {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mock();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumEsperado = CurriculumMock.mock();
		curriculumEsperado.setId(null);
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.save(eq(curriculumEsperado))).thenReturn(curriculumEsperado);
		
		final MvcResult mvcResult = mvc.perform(post(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(curriculumVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(curriculumVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularAtualizarCurriculo() throws Exception {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mockAtualizado();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumMock = CurriculumMock.mockAtualizado();
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.of(curriculumMock));
		when(curriculumRepository.save(eq(curriculumMock))).thenReturn(curriculumMock);
		
		final MvcResult mvcResult = mvc.perform(put(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(curriculumVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(curriculumVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarCurriculoQuandoCurriculumEncontrado() throws Exception {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mock();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumMock = CurriculumMock.mock();
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.of(curriculumMock));
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(curriculumVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarCurriculoQuandoCurriculumNaoEncontrado() throws Exception {
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.empty());
				
		final MvcResult mvcResult = mvc.perform(get(PATH+"/5")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertTrue(mvcResult.getResponse().getContentAsString().isEmpty());
	}

}
