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

@ExtendWith(MockitoExtension.class)
class CandidateControllerTest {
	
	
	@Mock
	private CandidateRepository repository;
	
	@Mock
	private UserRepository repositoryUser;
	
	@Mock
	private AuthoritiesRepository repositoryAuth;
	
	@InjectMocks
	private CandidateController candidateController;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
			
	
	@Test
	void deveCadastarCandidatos() {
		CandidateVM candidateVMMock = CandidateVMMock.mock();
		
		Candidate candidateEsperado = CandidateMock.mock();
		candidateEsperado.setId(null);
		Authorities authEsperado = AuthoritiesMock.mockCandidate();
		User userEsperado = UserMock.mockCandidate();
		
		when(repository.save(eq(candidateEsperado))).thenReturn(candidateEsperado);
		when(repositoryUser.save(eq(userEsperado))).thenReturn(userEsperado);
		when(repositoryAuth.save(eq(authEsperado))).thenReturn(authEsperado);
	
		ResponseEntity<CandidateVM> resposta = candidateController.cadastrarCandidatos(candidateVMMock);
		
		Assert.assertEquals(candidateVMMock, resposta.getBody());
	}
	
	@Test
	void deveBuscarCandidatosQuandoCandidatoEncontrado() {
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		
		CandidateVM candidateVMEsperado = CandidateVMMock.mock();
		candidateVMEsperado.setSenha(null);
		candidateVMEsperado.setEmailCandidate(null);
		
		when(repository.findById(5L)).thenReturn(candidateOptionalMock);
		
		ResponseEntity<CandidateVM> resposta = candidateController.buscarCandidate(5L);
		
		Assert.assertEquals(candidateVMEsperado, resposta.getBody());
	}
	
	@Test
	void deveBuscarCandidatosQuandoCandidatoNaoEncontrado() {
		when(repository.findById(5L)).thenReturn(Optional.empty());
		
		ResponseEntity<CandidateVM> resposta = candidateController.buscarCandidate(5L);
		
		Assert.assertEquals(null, resposta.getBody());		
	}
	
	@Test
	void deveAtualizarCandidatos() {
		CandidateVM candidateVMMock = CandidateVMMock.mockAtualizado();
		
		Optional<Candidate> candidateOptionalMock = Optional.of(CandidateMock.mock());
		when(repository.findById(5L)).thenReturn(candidateOptionalMock);
		
		Candidate candidateEsperado = CandidateMock.mockAtualizado();
		
		when(repository.save(eq(candidateEsperado))).thenReturn(candidateEsperado);
		
		ResponseEntity<CandidateVM> resposta = candidateController.atualizarCandidate(5L, candidateVMMock);
		
		Assert.assertEquals(candidateVMMock, resposta.getBody());
		
	}

}
