package br.com.zupacademy.halinecosta.casadocodigo.criaEstado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.halinecosta.casadocodigo.criaPais.PaisRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    EntityManager manager;
    @Autowired
    PaisRepository paisRepository;

  @Autowired
  ProibeEstadoDuplicadoEmPaisValidator proibeEstadoDuplicadoEmPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoDuplicadoEmPaisValidator);
    }

    @PostMapping
    @Transactional
    public String cadastar(@RequestBody @Valid EstadoRequest estadoRequest)
    {
       Estado estado = estadoRequest.converter(paisRepository);
       manager.persist(estado);
       return estado.toString();
    }
}
