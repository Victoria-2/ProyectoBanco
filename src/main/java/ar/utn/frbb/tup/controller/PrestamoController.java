package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.controller.validator.PrestamoValidator;
import ar.utn.frbb.tup.model.PrestamoConsulta;
import ar.utn.frbb.tup.model.PrestamoOutput;
import ar.utn.frbb.tup.model.exception.PrestamoNoOtorgadoException;
import ar.utn.frbb.tup.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @PostMapping
    public PrestamoOutput solicitarPrestamo(@RequestBody PrestamoDto prestamoDto) throws PrestamoNoOtorgadoException {
        PrestamoValidator.validate(prestamoDto);
        return prestamoService.pedirPrestamo(prestamoDto);
    }

    @GetMapping("/{clienteDni}")
    public PrestamoConsulta retonarPrestamosCliente(@PathVariable long clienteDni){
        //hacer un validator !!!
        return prestamoService.pedirConsultaPrestamos(clienteDni);
    }
}
