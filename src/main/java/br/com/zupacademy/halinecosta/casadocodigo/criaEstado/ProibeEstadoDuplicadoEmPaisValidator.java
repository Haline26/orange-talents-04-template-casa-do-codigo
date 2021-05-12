package br.com.zupacademy.halinecosta.casadocodigo.criaEstado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.halinecosta.casadocodigo.criaPais.Pais;
import br.com.zupacademy.halinecosta.casadocodigo.criaPais.PaisRepository;

import java.util.Optional;

@Component
public class ProibeEstadoDuplicadoEmPaisValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;

        EstadoRequest estadoRequest = (EstadoRequest) target;

        Optional<Pais> pais = paisRepository.findById(estadoRequest.getIdPais());
        if(pais.isEmpty())
            errors.rejectValue("idPais", "",
                    "Id cadastrado não existe  " +estadoRequest.getIdPais());

        Optional<Estado> estado = estadoRepository.findByNomeAndPaisId(estadoRequest.getNome(), estadoRequest.getIdPais());
        if(estado.isPresent())
            errors.rejectValue("nome", "", "Estado já existente " + estadoRequest.getNome()
                    + "  país " + estado.get().getPais().getNome());

    }
}
