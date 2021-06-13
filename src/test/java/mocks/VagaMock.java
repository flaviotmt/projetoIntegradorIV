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
		vaga.setInfoCargo("Informacao");
		vaga.setRegimeContratacao("Regime");
		vaga.setRequisistosCargo("Requisitos");
		vaga.setSalario("R$YY.YYY,YY");
		
		return vaga;
	}
	
	public static Vaga mockAtualizado() {
		Vaga vaga = new Vaga();
		vaga.setAtividadesCargo("Atividade2");
		vaga.setBeneficiosCargo("Beneficios2");
		vaga.setCargo("Cargo2");
		vaga.setCidadeCargo("Cidade2");
		vaga.setCompany(CompanyMock.mock());
		vaga.setDataFim(LocalDate.of(2021, 1, 7));
		vaga.setDataInicio(LocalDate.of(2021, 1, 2));
		vaga.setEstadoCargo("Estado2");
		vaga.setId(10L);
		vaga.setInfoCargo("Informacao2");
		vaga.setRegimeContratacao("Regime2");
		vaga.setRequisistosCargo("Requisitos2");
		vaga.setSalario("R$YY.YYY,YY2");
		
		return vaga;
	}
}
