package br.com.zupacademy.halinecosta.casadocodigo.criaLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.zupacademy.halinecosta.casadocodigo.ExistValue;
import br.com.zupacademy.halinecosta.casadocodigo.UniqueValue;
import br.com.zupacademy.halinecosta.casadocodigo.criaAutor.Autor;
import br.com.zupacademy.halinecosta.casadocodigo.criaAutor.AutorRepository;
import br.com.zupacademy.halinecosta.casadocodigo.criaCategoria.Categoria;
import br.com.zupacademy.halinecosta.casadocodigo.criaCategoria.CategoriaRepository;

public class LivroRequest {
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Já cadastrado")
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
	@Min(100)
	private Integer numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	@NotBlank
	@ExistValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria não existente no banco")
	private String nomeCategoria;
	@NotBlank
	@ExistValue(domainClass = Autor.class, fieldName = "nome", message = "Autor não existente no banco")
	private String nomeAutor;

	@Deprecated
	public LivroRequest() {
	}

	public LivroRequest(Livro livro){
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeCategoria = livro.getCategoria().getNome();
		this.nomeAutor = livro.getAutor().getNome();
	}

	public String getTitulo() {
		return titulo;
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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {

		Optional<Categoria> categoria = categoriaRepository.findByNome(nomeCategoria);
		Optional<Autor> autor = autorRepository.findByNome(nomeAutor);
		
		if (categoria.isPresent() && autor.isPresent())
			return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria.get(),
					autor.get());
		
		return null;
	}

}
