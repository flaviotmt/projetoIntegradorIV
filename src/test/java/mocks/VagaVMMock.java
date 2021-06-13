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
		vagaVM.setInfoCargo("Informacao");
		vagaVM.setNomeEmpresa("Companhia");
		vagaVM.setRegimeContratacao("Regime");
		vagaVM.setRequisistosCargo("Requisitos");
		vagaVM.setSalario("R$YY.YYY,YY");
		
		return vagaVM;
		
	}
	
	public static VagaVM mockAtualizado() {
		VagaVM vagaVM = new VagaVM();
		vagaVM.setAtividadesCargo("Atividade2");
		vagaVM.setBeneficiosCargo("Beneficios2");
		vagaVM.setCargo("Cargo2");
		vagaVM.setCidadeCargo("Cidade2");
		vagaVM.setDataFim(LocalDate.of(2021, 1, 7));
		vagaVM.setDataInicio(LocalDate.of(2021, 1, 2));
		vagaVM.setEstadoCargo("Estado2");
		vagaVM.setId(10L);
		vagaVM.setInfoCargo("Informacao2");
		vagaVM.setNomeEmpresa("Companhia");
		vagaVM.setRegimeContratacao("Regime2");
		vagaVM.setRequisistosCargo("Requisitos2");
		vagaVM.setSalario("R$YY.YYY,YY2");
		
		return vagaVM;
		
	}

}
