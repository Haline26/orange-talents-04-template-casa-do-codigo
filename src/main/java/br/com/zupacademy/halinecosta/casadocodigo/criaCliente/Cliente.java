package br.com.zupacademy.halinecosta.casadocodigo.criaCliente;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.halinecosta.casadocodigo.criaEstado.Estado;
import br.com.zupacademy.halinecosta.casadocodigo.criaPais.Pais;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String sobrenome;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private String complemento;
    @NotEmpty
    private String cidade;
    @ManyToOne @NotNull
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotEmpty
    private String telefone;
    @NotEmpty
    private String cep;

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                   String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
