package com.recomecar.projeto.recomecar.projeto.controller.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import com.recomecar.projeto.recomecar.projeto.model.Company;
import com.recomecar.projeto.recomecar.projeto.model.Vaga;
import com.recomecar.projeto.recomecar.projeto.repository.CompanyRepository;
import com.recomecar.projeto.recomecar.projeto.repository.VagasRepository;
import com.recomecar.projeto.recomecar.projeto.viewmodel.VagaVM;

import mocks.CompanyMock;
import mocks.VagaMock;
import mocks.VagaVMMock;

@RunWith(SpringRunner.class)
@WebMvcTest(VagaController.class)
@ContextConfiguration(classes={Application.class})
public class VagaControllerMVCTest {
	
	@MockBean
	private VagasRepository repository;
	
	@MockBean
	private CompanyRepository repositoryCompany;
		
	@MockBean
	private DataSource dataSource;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
		
	private static final String PATH = "/v1/vaga";
	
	@Test
	void simularCadastrarVaga() throws Exception {
		VagaVM vagaVMMock = VagaVMMock.mock();
		Company company = CompanyMock.mock();
				
		Vaga vagaEsperado = VagaMock.mock();
		vagaEsperado.setId(null);
		
		when(repositoryCompany.findById(2L)).thenReturn(Optional.of(company));
		when(repository.save(eq(vagaEsperado))).thenReturn(vagaEsperado);
		
		final MvcResult mvcResult = mvc.perform(post(PATH+"/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(vagaVMString(vagaVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(vagaVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularAtualizarVaga() throws Exception {
		VagaVM vagaVMMock = VagaVMMock.mockAtualizado();
		Optional<Vaga> vagaOptionalMock = Optional.of(VagaMock.mock());
		
		Vaga vagaEsperada = VagaMock.mockAtualizado();
		
		when(repository.findById(10L)).thenReturn(vagaOptionalMock);
		when(repository.save(eq(vagaEsperada))).thenReturn(vagaEsperada);
		
		final MvcResult mvcResult = mvc.perform(put(PATH+"/10")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(vagaVMString(vagaVMMock)))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(vagaVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarVagaQuandoVagaEncontrada() throws Exception {
		VagaVM vagaVMMock = VagaVMMock.mock();
		vagaVMMock.setId(null);
		vagaVMMock.setNomeEmpresa(null);

		Optional<Vaga> vagaOptionalMock = Optional.of(VagaMock.mock());
		
		when(repository.findById(10L)).thenReturn(vagaOptionalMock);
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/10")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(vagaVMMock), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarVagaQuandoVagaNaoEncontrada() throws Exception {
		when(repository.findById(10L)).thenReturn(Optional.empty());
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/10")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertTrue(mvcResult.getResponse().getContentAsString().isEmpty());
	}
	
	@Test
	void simularBuscarVagas() throws Exception {
		VagaVM vagaVMMock = VagaVMMock.mock();

		List<Vaga> vagaOptionalMock = new ArrayList<>();
		vagaOptionalMock.add(VagaMock.mock());
		
		when(repository.findAll()).thenReturn(vagaOptionalMock);
		
		final MvcResult mvcResult = mvc.perform(get(PATH)
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(Collections.singletonList(vagaVMMock)), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarVagasEmpresaQuandoVagaEncontrada() throws Exception {
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
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/emp/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertEquals(objectMapper.writeValueAsString(Collections.singletonList(vagaVMMock)), 
				mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void simularBuscarVagasEmpresaQuandoVagaNaoEncontrada() throws Exception {
		Company company = CompanyMock.mock();
		List<Vaga> vagas = new ArrayList<>();
		vagas.add(VagaMock.mock());
		company.setVagas(vagas);
		Optional<Company> companyOptionalMock = Optional.of(company);

		List<Vaga> vagaOptionalMock = new ArrayList<>();
		vagaOptionalMock.add(VagaMock.mock());
		
		when(repositoryCompany.findById(2L)).thenReturn(companyOptionalMock);
		when(repository.findByCompany(eq(companyOptionalMock.get()))).thenReturn(Optional.empty());
		
		final MvcResult mvcResult = mvc.perform(get(PATH+"/emp/2")
				.with(user("user"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		Assert.assertTrue(mvcResult.getResponse().getContentAsString().isEmpty());
	}
	
	
	private String vagaVMString(VagaVM vagaVMMock) {
	
		String desc = "{\"cargo\": \"" + vagaVMMock.getCargo() + "\", "
		+ "\"salario\": \"" + vagaVMMock.getSalario() + "\", "
		+ "\"regimeContratacao\": \"" + vagaVMMock.getRegimeContratacao() + "\", "
		+ "\"estadoCargo\": \"" + vagaVMMock.getEstadoCargo() + "\", "
		+ "\"cidadeCargo\": \"" + vagaVMMock.getCidadeCargo() + "\", "
		+ "\"dataInicio\": \"" + vagaVMMock.getDataInicio().toString() + "\", "
		+ "\"dataFim\": \"" + vagaVMMock.getDataFim().toString() + "\", "
		+ "\"atividadesCargo\": \"" + vagaVMMock.getAtividadesCargo() + "\", "
		+ "\"beneficiosCargo\": \"" + vagaVMMock.getBeneficiosCargo() + "\", "
		+ "\"requisistosCargo\": \"" + vagaVMMock.getRequisistosCargo() + "\", "
		+ "\"infoCargo\": \"" + vagaVMMock.getInfoCargo() + "\", "
		+ "\"nomeEmpresa\": \"" + vagaVMMock.getNomeEmpresa() + "\", "
		+ "\"id\":" + vagaVMMock.getId().toString() + "}";

		return desc;
	}
	

}
