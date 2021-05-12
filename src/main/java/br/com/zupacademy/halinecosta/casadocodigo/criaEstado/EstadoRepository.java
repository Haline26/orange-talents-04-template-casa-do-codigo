package br.com.zupacademy.halinecosta.casadocodigo.criaEstado;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisId(String nome, Long idPais);

    List<Estado> findByPaisId(Long idPais);
}
