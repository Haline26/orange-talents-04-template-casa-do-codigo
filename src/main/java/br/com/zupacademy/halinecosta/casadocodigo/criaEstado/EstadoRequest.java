package br.com.zupacademy.halinecosta.casadocodigo.criaEstado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.halinecosta.casadocodigo.UniqueValue;
import br.com.zupacademy.halinecosta.casadocodigo.criaPais.Pais;
import br.com.zupacademy.halinecosta.casadocodigo.criaPais.PaisRepository;

import java.util.Optional;

public class EstadoRequest {
    @NotBlank
    private String nome;
    @NotNull
    private Long idPais;

    @Deprecated
    public EstadoRequest() {
    }

    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(idPais);
        if (pais.isPresent())
            return new Estado(nome, pais.get());
        return null;
    }
}
