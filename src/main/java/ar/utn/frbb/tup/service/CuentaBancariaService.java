package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.CuentaBancariaDto;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.CuentaAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.CuentaNoSoportadaException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ar.utn.frbb.tup.model.TipoMoneda;
import ar.utn.frbb.tup.model.TipoDeCuenta;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuentaBancariaService {
    @Autowired
    ClienteService clienteService;
    @Autowired
    CuentaBancariaDao cuentaDao;


    public boolean tipoCuentaEstaSoportada(CuentaBancariaDto cuenta){ //A MEJORAR
        if((cuenta.getMoneda().equals(TipoMoneda.PESO_ARGENTINO.getDescripcion()) && (cuenta.getTipoCuenta().equals(TipoDeCuenta.CAJA_DE_AHORROS.getDescripcion())))){
            return true;
        } else if((cuenta.getMoneda().equals(TipoMoneda.DOLAR.getDescripcion()) && (cuenta.getTipoCuenta().equals( TipoDeCuenta.CAJA_DE_AHORROS.getDescripcion())))){
            return true;
        } else return (cuenta.getMoneda().equals( TipoMoneda.PESO_ARGENTINO.getDescripcion()) && (cuenta.getTipoCuenta().equals( TipoDeCuenta.CUENTA_CORRIENTE.getDescripcion())));
    }

    public CuentaBancaria darDeAltaCuenta(CuentaBancariaDto cuentaDto) throws CuentaAlreadyExistsException, TipoCuentaAlreadyExistsException, CuentaNoSoportadaException {
        if(cuentaDao.find(cuentaDto.getDniTitular()) != null) { //nes el dni
            throw new CuentaAlreadyExistsException("La cuenta con el dni " + cuentaDto.getDniTitular() + " ya existe");
        }

        //Chequear cuentas soportadas por el banco CA$ CC$ CAU$S
        if (!tipoCuentaEstaSoportada(cuentaDto)) {
            throw new CuentaNoSoportadaException("Ya posee una cuenta del tipo " + cuentaDto.getTipoCuenta());
        }

        CuentaBancaria cuenta = new CuentaBancaria(cuentaDto);

        clienteService.agregarCuenta(cuenta, cuentaDto.getDniTitular());
        return cuenta;
    }

    public CuentaBancaria find(int id) {
        return cuentaDao.find(id);
    }


    public void actualizarCuentaCliente(String cbu, double montoPrestamo){
        CuentaBancaria cuentaCliente = find(Integer.parseInt(cbu));
        cuentaCliente.setSaldo(cuentaCliente.getSaldo() + montoPrestamo);
    }

}
