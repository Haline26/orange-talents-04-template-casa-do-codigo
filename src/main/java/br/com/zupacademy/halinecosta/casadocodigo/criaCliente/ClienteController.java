package br.com.zupacademy.halinecosta.casadocodigo.criaCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.halinecosta.casadocodigo.criaEstado.EstadoRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RestricaoPaisEstadoValidator restricaoPaisEstadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(restricaoPaisEstadoValidator);
    }


    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.converter(estadoRepository);
        clienteRepository.save(cliente);
        return  clienteRequest.toString();
    }
}
