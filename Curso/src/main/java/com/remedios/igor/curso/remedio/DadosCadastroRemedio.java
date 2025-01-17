package com.remedios.igor.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

//classe imotavel, ja vem por padrão getter e setter

public record DadosCadastroRemedio(
		//NottNull
		@NotBlank
		String nome,
		
		@Enumerated
	    Via via,
	    
	    @NotBlank
	    String lote,
	    
	    
	    int quantidade,
	    
	    @Future
	    LocalDate validade,
	    
	    @Enumerated
	    Laboratorio laboratorio,
	    
	    String ativo
		
		
	) {

}
