package com.remedios.igor.curso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedios.igor.curso.remedio.DadosCadastroRemedio;
import com.remedios.igor.curso.remedio.DadosDetalhamentoRemedios;
import com.remedios.igor.curso.remedio.Remedio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/logiin") 
public class Login {

	@PostMapping
	public ResponseEntity<DadosLogin> logarSistema(@RequestBody DadosLogin dados) { 
	
		
		return ResponseEntity.ok(dados);
	}
}
