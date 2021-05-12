package br.com.zupacademy.halinecosta.casadocodigo.criaCategoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.halinecosta.casadocodigo.UniqueValue;

public class CategoriaRequest {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome já existente.")
	public String nome;
	
	@Deprecated
	public CategoriaRequest() {
	}

	public CategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

}
