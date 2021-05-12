package br.com.zupacademy.halinecosta.casadocodigo.criaCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.halinecosta.casadocodigo.criaEstado.Estado;
import br.com.zupacademy.halinecosta.casadocodigo.criaEstado.EstadoRepository;

import java.util.List;
import java.util.Optional;

@Component
public class RestricaoPaisEstadoValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors())
            return;

        ClienteRequest clienteRequest = (ClienteRequest) target;
        Long idPais = clienteRequest.getIdPais();
        Long idEstado = clienteRequest.getIdEstado();
       
        if (idEstado != null) { 
            Optional<Estado> estado = estadoRepository.findById(idEstado);
            if(estado.isEmpty())
                errors.rejectValue("idEstado", "",
                        "ID do estado" + idEstado + " não existe no bando de dados.");
            else {
                
                if (!estado.get().getPais().getId().equals(idPais)) {
                    errors.rejectValue("idEstado", "",
                            "Estado inexistente " + idEstado + " para o país " + idPais);
                }
            }

        } else {
           

            List<Estado> estadosDoPais = estadoRepository.findByPaisId(idPais);
            if (estadosDoPais.size() > 0) {
                errors.rejectValue("idPais", "",
                        "existem estados cadastrados neste pais. Selecione: ");
            }
        }

    }
}
