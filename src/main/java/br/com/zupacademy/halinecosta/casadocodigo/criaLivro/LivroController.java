package br.com.zupacademy.halinecosta.casadocodigo.criaLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.halinecosta.casadocodigo.criaAutor.AutorRepository;
import br.com.zupacademy.halinecosta.casadocodigo.criaCategoria.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("livro")
public class LivroController {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	LivroRepository livroRepository;
	
	@PersistenceContext
	EntityManager manager;

	@GetMapping("{id}")
	public ResponseEntity<LivroRequest> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent())
			return ResponseEntity.ok((new LivroRequest(livro.get())));
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<ItemListaLivro> listar(){
		List<ItemListaLivro> lista = new ArrayList<>();
		return ItemListaLivro.converter( livroRepository.findAll());
	}

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroRequest request) {
		Livro livro = request.converter(categoriaRepository, autorRepository);
		manager.persist(livro);
		return livro.toString();
	}

}
