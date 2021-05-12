package br.com.zupacademy.halinecosta.casadocodigo.criaPais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.converter();
        manager.persist(pais);
        return pais.toString();
    }
}
