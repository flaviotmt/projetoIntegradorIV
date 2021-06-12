package mocks;

import java.time.LocalDate;

import com.recomecar.projeto.recomecar.projeto.model.Vaga;

public class VagaMock {

	public static Vaga mock() {
		Vaga vaga = new Vaga();
		vaga.setAtividadesCargo("Atividade");
		vaga.setBeneficiosCargo("Beneficios");
		vaga.setCargo("Cargo");
		vaga.setCidadeCargo("Cidade");
		vaga.setCompany(CompanyMock.mock());
		vaga.setDataFim(LocalDate.of(2021, 1, 6));
		vaga.setDataInicio(LocalDate.of(2021, 1, 1));
		vaga.setEstadoCargo("Estado");
		vaga.setId(10L);
		vaga.setInfoCargo("Informação");
		vaga.setRegimeContratacao("Regime");
		vaga.setRequisistosCargo("Requisitos");
		vaga.setSalario("R$ YY.YYY,YY");
		
		return vaga;
	}
	
	public static Vaga mockAtualizado() {
		Vaga vaga = new Vaga();
		vaga.setAtividadesCargo("Atividade 2");
		vaga.setBeneficiosCargo("Beneficios 2");
		vaga.setCargo("Cargo 2");
		vaga.setCidadeCargo("Cidade 2");
		vaga.setCompany(CompanyMock.mock());
		vaga.setDataFim(LocalDate.of(2021, 1, 7));
		vaga.setDataInicio(LocalDate.of(2021, 1, 2));
		vaga.setEstadoCargo("Estado 2");
		vaga.setId(10L);
		vaga.setInfoCargo("Informação 2");
		vaga.setRegimeContratacao("Regime 2");
		vaga.setRequisistosCargo("Requisitos 2");
		vaga.setSalario("R$ YY.YYY,YY 2");
		
		return vaga;
	}
}
