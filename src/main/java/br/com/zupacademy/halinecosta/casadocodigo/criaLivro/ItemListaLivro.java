package br.com.zupacademy.halinecosta.casadocodigo.criaLivro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ItemListaLivro {
	private final Long id;
	private final String titulo;

	public ItemListaLivro(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public static List<ItemListaLivro> converter(Iterable<Livro> livros) {
		List<ItemListaLivro> livrosDto = new ArrayList<ItemListaLivro>();
		livros.forEach(l -> livrosDto.add( new ItemListaLivro(l)));
		return livrosDto;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public ItemListaLivro(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

}
