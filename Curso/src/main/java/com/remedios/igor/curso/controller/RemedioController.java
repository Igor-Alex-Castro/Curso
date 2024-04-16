package com.remedios.igor.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedios.igor.curso.remedio.DadosAtualizarRemedio;
import com.remedios.igor.curso.remedio.DadosCadastroRemedio;
import com.remedios.igor.curso.remedio.DadosDetalhamentoRemedios;
import com.remedios.igor.curso.remedio.DadosListagemRemedios;
import com.remedios.igor.curso.remedio.Remedio;
import com.remedios.igor.curso.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController // Diz para o spring que é um controller
@RequestMapping("/remedios") //nomear o nosso endpoint
public class RemedioController {
	
	
	@Autowired
	RemedioRepository remedioRepository;
	
	//@PostMapping Cria um metodo do tipo POST -> envio
	//@RequestBoby Diz para o spring da onde que esta vindo as informações
	//DTO - data transfer object, melhor maneira de enviar dado para api, serve par filtrar, e uma boa pratica para api rest
	// Uma api vai listar remedios, padrao de obj no projeo, não precisa entregar todo o projeto.
	//client -> dto -> web service
	@PostMapping
	@Transactional //quando a aplicação de algum erro, faz um rollback no banco
	public ResponseEntity<DadosDetalhamentoRemedios> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder) { 
		var remedio = new  Remedio(dados);
		
		remedioRepository.save(remedio);
		
		var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedios(remedio));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<DadosListagemRemedios>> listar(){
		var lista = remedioRepository.lisyRmediosAtivos("ATIVO").stream().map(DadosListagemRemedios::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoRemedios> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
		 var remedio = remedioRepository.getReferenceById(dados.id());
		 remedio.atualizarInformacao(dados);
		 
		 return ResponseEntity.ok(new DadosDetalhamentoRemedios(remedio));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id ) {
		remedioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		var remedio = remedioRepository.getReferenceById(id);
		remedio.inativar();
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("ativar/{id}")
	@Transactional
	public  ResponseEntity<?> Reativar(@PathVariable Long id) {
		
		var remedio = remedioRepository.getReferenceById(id);
		remedio.reativar();
		
		return ResponseEntity.ok(remedio);
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosDetalhamentoRemedios> detalhar(@PathVariable Long id ){
		var remedio = remedioRepository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoRemedios(remedio));
		
	}
	
	
}
