package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.controller.validator.CuentaBancariaValidator;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.CuentaAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.CuentaNoSoportadaException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.utn.frbb.tup.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
public class CuentaBancariaController {
    @Autowired
    public CuentaBancariaService cuentaService;

    @Autowired
    public CuentaBancariaValidator cuentaValidator;

    @PostMapping
    public CuentaBancaria crearCuenta(@RequestBody CuentaBancariaDto cuentaBancariaDto) throws CuentaNoSoportadaException, TipoCuentaAlreadyExistsException, CuentaAlreadyExistsException {
        CuentaBancariaValidator.validate(cuentaBancariaDto);
        return cuentaService.darDeAltaCuenta(cuentaBancariaDto);
    }
}
