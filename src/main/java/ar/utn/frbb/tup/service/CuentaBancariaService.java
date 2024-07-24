package ar.utn.frbb.tup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuentaBancariaService {

    @Autowired
    ClienteService clienteService;

}
