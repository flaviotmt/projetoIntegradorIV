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

import com.recomecar.projeto.recomecar.projeto.model.Candidate;
import com.recomecar.projeto.recomecar.projeto.model.Curriculum;
import com.recomecar.projeto.recomecar.projeto.repository.CandidateRepository;
import com.recomecar.projeto.recomecar.projeto.repository.CurriculumRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.CurriculumVM;

import mocks.CandidateMock;
import mocks.CurriculumMock;
import mocks.CurriculumVMMock;

@ExtendWith(MockitoExtension.class)
class CurriculumControllerTest {
	
	@Mock
	private CurriculumRepository curriculumRepository;
	
	@Mock
	private CandidateRepository candidateRepository;
	
	@InjectMocks
	private CurriculumController curriculumController;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void deveCadastarCurriculo() {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mock();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumEsperado = CurriculumMock.mock();
		curriculumEsperado.setId(null);
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.save(eq(curriculumEsperado))).thenReturn(curriculumEsperado);
		
		ResponseEntity<CurriculumVM> resposta = curriculumController.cadastrarCurriculo(5L, curriculumVMMock);
		
		Assert.assertEquals(curriculumVMMock, resposta.getBody());
	}
	
	@Test
	void deveAtualizarCurriculo() {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mockAtualizado();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumMock = CurriculumMock.mockAtualizado();
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.of(curriculumMock));
		when(curriculumRepository.save(eq(curriculumMock))).thenReturn(curriculumMock);
		
		ResponseEntity<CurriculumVM> resposta = curriculumController.atualizarCurriculo(5L, curriculumVMMock);
		
		Assert.assertEquals(curriculumVMMock, resposta.getBody());
	}
	
	@Test
	void deveBuscarCurriculoQuandoCurriculumEncontrado() {
		CurriculumVM curriculumVMMock = CurriculumVMMock.mock();
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		Curriculum curriculumMock = CurriculumMock.mock();
		
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.of(curriculumMock));
		
		ResponseEntity<CurriculumVM> resposta = curriculumController.buscarCurriculo(5L);
		
		Assert.assertEquals(curriculumVMMock, resposta.getBody());
		
	}
	
	@Test
	void deveBuscarCurriculoQuandoCurriculumNaoEncontrado() {
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
				
		when(candidateRepository.findById(5L)).thenReturn(candidateOptionalMock);
		when(curriculumRepository.findByCandidate(eq(candidateOptionalMock.get()))).thenReturn(Optional.empty());
		
		ResponseEntity<CurriculumVM> resposta = curriculumController.buscarCurriculo(5L);
		
		Assert.assertEquals(null, resposta.getBody());
		
	}

}
