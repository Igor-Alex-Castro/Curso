package com.remedios.igor.curso.remedio;

import java.time.LocalDate;

public record DadosDetalhamentoRemedios(
		
		Long id,
		
		String nome,
		
		Via via,
		
		String lote,
		
		int quantidade,
		
		LocalDate validade, 
		
		Laboratorio laboratorio, 
		
		String ativo			
) {
	
	public DadosDetalhamentoRemedios(Remedio remedio) {
		this(remedio.getId(), 
				remedio.getNome(),
				remedio.getVia(),
				remedio.getLote(),
				remedio.getQuantidade(),
				remedio.getValidade(),
				remedio.getLaboratorio(),
				remedio.getAtivo()
				);
	}

	
}
