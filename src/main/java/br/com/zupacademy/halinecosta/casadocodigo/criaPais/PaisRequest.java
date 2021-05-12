package br.com.zupacademy.halinecosta.casadocodigo.criaPais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.halinecosta.casadocodigo.UniqueValue;

public class PaisRequest {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisRequest() {
    }

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
