package com.recomecar.projeto.recomecar.projeto.controller.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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

import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.Vaga;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;
import com.recomecar.projeto.recomecar.projeto.repository.VagasRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.VagaVM;

import mocks.CompanyMock;
import mocks.VagaMock;
import mocks.VagaVMMock;

@ExtendWith(MockitoExtension.class)
class VagaControllerTest {
	
	@Mock
	private VagasRepository repository;
	
	@Mock
	private CompanyRepository repositoryCompany;
	
	@InjectMocks
	private VagaController vagaController;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void deveCadastrarVaga() {
		VagaVM vagaVMMock = VagaVMMock.mock();
		Company company = CompanyMock.mock();
		
		Vaga vagaEsperado = VagaMock.mock();
		vagaEsperado.setId(null);
		
		when(repositoryCompany.findById(2L)).thenReturn(Optional.of(company));
		when(repository.save(eq(vagaEsperado))).thenReturn(vagaEsperado);
		
		ResponseEntity<VagaVM> resposta = vagaController.cadastrarVaga(2L, vagaVMMock);
		
		Assert.assertEquals(vagaVMMock, resposta.getBody());
	}
	
	@Test
	void deveAtualizarVaga() {
		VagaVM vagaVMMock = VagaVMMock.mockAtualizado();
		Optional<Vaga> vagaOptionalMock = Optional.of(VagaMock.mock());
		
		Vaga vagaEsperada = VagaMock.mockAtualizado();
		
		when(repository.findById(10L)).thenReturn(vagaOptionalMock);
		when(repository.save(eq(vagaEsperada))).thenReturn(vagaEsperada);
		
		ResponseEntity<VagaVM> resposta = vagaController.atualizarVaga(10L, vagaVMMock);
		
		Assert.assertEquals(vagaVMMock, resposta.getBody());
	}
	
	@Test
	void deveBuscarVagaQuandoVagaEncontrada() {
		VagaVM vagaVMMock = VagaVMMock.mock();
		vagaVMMock.setId(null);
		vagaVMMock.setNomeEmpresa(null);

		Optional<Vaga> vagaOptionalMock = Optional.of(VagaMock.mock());
		
		when(repository.findById(10L)).thenReturn(vagaOptionalMock);
		
		ResponseEntity<VagaVM> resposta = vagaController.buscarVaga(10L);
		
		Assert.assertEquals(vagaVMMock, resposta.getBody());
		
	}
	
	@Test
	void deveBuscarVagaQuandoVagaNaoEncontrada() {		
		when(repository.findById(10L)).thenReturn(Optional.empty());
		
		ResponseEntity<VagaVM> resposta = vagaController.buscarVaga(10L);
		
		Assert.assertEquals(null, resposta.getBody());
		
	}
	
	@Test
	void deveBuscarVagas() {
		VagaVM vagaVMMock = VagaVMMock.mock();

		List<Vaga> vagaOptionalMock = new ArrayList<>();
		vagaOptionalMock.add(VagaMock.mock());
		
		when(repository.findAll()).thenReturn(vagaOptionalMock);
		
		ResponseEntity<List<VagaVM>> resposta = vagaController.buscarVagas();
		
		Assert.assertEquals(1, resposta.getBody().size());
		Assert.assertEquals(vagaVMMock, resposta.getBody().get(0));
		
	}
	
	
	@Test
	void deveBuscarVagasEmpresaQuandoVagaEncontrada() {
		VagaVM vagaVMMock = VagaVMMock.mock();
		Company company = CompanyMock.mock();
		List<Vaga> vagas = new ArrayList<>();
		vagas.add(VagaMock.mock());
		company.setVagas(vagas);
		Optional<Company> companyOptionalMock = Optional.of(company);

		List<Vaga> vagaOptionalMock = new ArrayList<>();
		vagaOptionalMock.add(VagaMock.mock());
		
		when(repositoryCompany.findById(2L)).thenReturn(companyOptionalMock);
		when(repository.findByCompany(eq(companyOptionalMock.get()))).thenReturn(Optional.of(vagaOptionalMock));
		
		ResponseEntity<List<VagaVM>> resposta = vagaController.buscarVagasEmpresa(2L);
		
		Assert.assertEquals(1, resposta.getBody().size());
		Assert.assertEquals(vagaVMMock, resposta.getBody().get(0));
		
	}
	
	@Test
	void deveBuscarVagasEmpresaQuandoVagaNaoEncontrada() {
		Company company = CompanyMock.mock();
		List<Vaga> vagas = new ArrayList<>();
		vagas.add(VagaMock.mock());
		company.setVagas(vagas);
		Optional<Company> companyOptionalMock = Optional.of(company);

		List<Vaga> vagaOptionalMock = new ArrayList<>();
		vagaOptionalMock.add(VagaMock.mock());
		
		when(repositoryCompany.findById(2L)).thenReturn(companyOptionalMock);
		when(repository.findByCompany(eq(companyOptionalMock.get()))).thenReturn(Optional.empty());
		
		ResponseEntity<List<VagaVM>> resposta = vagaController.buscarVagasEmpresa(2L);
		
		Assert.assertEquals(null, resposta.getBody());
		
	}

}
