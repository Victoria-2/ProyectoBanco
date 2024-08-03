package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.controller.validator.ClienteValidator;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;
import ar.utn.frbb.tup.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteValidator clienteValidator;

    @PostMapping
    public Cliente crearCliente(@RequestBody ClienteDto clienteDto) throws ClienteAlreadyExistsException {
        clienteValidator.validate(clienteDto);
        return clienteService.darDeAltaCliente(clienteDto);
    }

    @GetMapping("/cuentas/{clienteDni}")
    public List<CuentaBancaria> retonarCuentasCliente(@PathVariable int clienteDni){
        //aca tiene que ir un validator por si no tiene cuentas todavia
        return clienteService.getCuentasCliente(clienteDni);
    }
}
