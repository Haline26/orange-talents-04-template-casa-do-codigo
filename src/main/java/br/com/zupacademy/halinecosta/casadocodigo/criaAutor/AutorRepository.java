package br.com.zupacademy.halinecosta.casadocodigo.criaAutor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	public Optional<Autor> findByEmail(String email);

	public Optional<Autor> findByNome(String nomeAutor);
}
