package br.com.zupacademy.halinecosta.casadocodigo.criaLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.zupacademy.halinecosta.casadocodigo.criaAutor.Autor;
import br.com.zupacademy.halinecosta.casadocodigo.criaCategoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "sumario")
	private String sumario;
	@NotNull
	@DecimalMin("40.00")
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	@NotBlank
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@ManyToOne
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotBlank LocalDate dataPublicacao, @NotBlank Categoria categoria, @NotBlank Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}



	@Override
	public String toString() {
		return "Livro: " + titulo + " criado com exito";
	}
	
	

}
