package com.remedios.igor.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "remedio")
@Entity(name = "remedio")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
	
	public Remedio(DadosCadastroRemedio dados) {
		this.ativo = dados.ativo();
		this.nome = dados.nome();
		this.via = dados.via();
		this.lote = dados.lote();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
		this.laboratorio = dados.laboratorio();
		
	}
	
	public Remedio() {
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String nome;
	
	@Enumerated(EnumType.STRING)
    Via via;
    String lote;
    int quantidade;
    LocalDate validade;
    
    @Enumerated(EnumType.STRING)
    Laboratorio laboratorio;

   @Column(name="ATIVO")
    private String ativo;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Via getVia() {
		return via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public void atualizarInformacao(@Valid DadosAtualizarRemedio dados) {
		// TODO Auto-generated method stub
		
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	
		if(dados.via() != null) {
			this.via = dados.via();
		}
		
		if(dados.laboratorio() != null) {
			this.laboratorio = dados.laboratorio();
		}
		
	}

	public void inativar() {
		// TODO Auto-generated method stub
		this.setAtivo("INATIVO");
	}
	
	public void reativar() {
		this.setAtivo("ATIVO");
	}

	

    
}
