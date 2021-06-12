package mocks;

import java.time.LocalDate;

import com.recomecar.projeto.recomecar.projeto.viewmodel.VagaVM;

public class VagaVMMock {
	
	public static VagaVM mock() {
		VagaVM vagaVM = new VagaVM();
		vagaVM.setAtividadesCargo("Atividade");
		vagaVM.setBeneficiosCargo("Beneficios");
		vagaVM.setCargo("Cargo");
		vagaVM.setCidadeCargo("Cidade");
		vagaVM.setDataFim(LocalDate.of(2021, 1, 6));
		vagaVM.setDataInicio(LocalDate.of(2021, 1, 1));
		vagaVM.setEstadoCargo("Estado");
		vagaVM.setId(10L);
		vagaVM.setInfoCargo("Informação");
		vagaVM.setNomeEmpresa("Companhia");
		vagaVM.setRegimeContratacao("Regime");
		vagaVM.setRequisistosCargo("Requisitos");
		vagaVM.setSalario("R$ YY.YYY,YY");
		
		return vagaVM;
		
	}
	
	public static VagaVM mockAtualizado() {
		VagaVM vagaVM = new VagaVM();
		vagaVM.setAtividadesCargo("Atividade 2");
		vagaVM.setBeneficiosCargo("Beneficios 2");
		vagaVM.setCargo("Cargo 2");
		vagaVM.setCidadeCargo("Cidade 2");
		vagaVM.setDataFim(LocalDate.of(2021, 1, 7));
		vagaVM.setDataInicio(LocalDate.of(2021, 1, 2));
		vagaVM.setEstadoCargo("Estado 2");
		vagaVM.setId(10L);
		vagaVM.setInfoCargo("Informação 2");
		vagaVM.setNomeEmpresa("Companhia");
		vagaVM.setRegimeContratacao("Regime 2");
		vagaVM.setRequisistosCargo("Requisitos 2");
		vagaVM.setSalario("R$ YY.YYY,YY 2");
		
		return vagaVM;
		
	}

}
