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

@Component
public class CuentaBancariaService {
    @Autowired
    ClienteService clienteService;
    @Autowired
    CuentaBancariaDao cuentaDao;


    public boolean tipoCuentaEstaSoportada(CuentaBancariaDto cuenta){ //A MEJORAR
        if((cuenta.getMoneda().equals(TipoMoneda.PESO_ARGENTINO.toString()) && (cuenta.getTipoCuenta().equals(TipoDeCuenta.CAJA_DE_AHORROS.toString())))){
            return true;
        } else if((cuenta.getMoneda().equals(TipoMoneda.DOLAR.toString()) && (cuenta.getTipoCuenta().equals( TipoDeCuenta.CAJA_DE_AHORROS.toString())))){
            return true;
        } else return (cuenta.getMoneda().equals( TipoMoneda.PESO_ARGENTINO.toString()) && (cuenta.getTipoCuenta().equals( TipoDeCuenta.CUENTA_CORRIENTE.toString())));
    }

    /*
    public boolean tipoCuentaEstaSoportada(CuentaBancaria cuenta) {
        EnumSet<TipoDeCuenta> cuentasSoportadas = EnumSet.noneOf(TipoDeCuenta.class);

        if (cuenta.getMoneda() == TipoMoneda.PESO_ARGENTINO) {
            cuentasSoportadas.add(TipoDeCuenta.CAJA_DE_AHORROS);
            cuentasSoportadas.add(TipoDeCuenta.CUENTA_CORRIENTE);
        } else if (cuenta.getMoneda() == TipoMoneda.DOLAR) {
            cuentasSoportadas.add(TipoDeCuenta.CAJA_DE_AHORROS);
        }

        return cuentasSoportadas.contains(cuenta.getTipoCuenta());
    }

     */

    public CuentaBancaria darDeAltaCuenta(CuentaBancariaDto cuentaDto) throws CuentaAlreadyExistsException, TipoCuentaAlreadyExistsException, CuentaNoSoportadaException {
        if(cuentaDao.find(cuentaDto.getDniTitular()) != null) { //nes el dni
            throw new CuentaAlreadyExistsException("La cuenta con el dni " + cuentaDto.getDniTitular() + " ya existe");
        }

        //Chequear cuentas soportadas por el banco CA$ CC$ CAU$S
        if (!tipoCuentaEstaSoportada(cuentaDto)) {
            throw new CuentaNoSoportadaException("Ya posee una cuenta del tipo " + cuentaDto.getTipoCuenta());
        }

        CuentaBancaria cuenta = new CuentaBancaria(cuentaDto);

        clienteService.agregarCuenta(cuenta, cuenta.getTitular().getDni());
        cuentaDao.save(cuenta);
        return cuenta;
    }

    public CuentaBancaria find(int id) {
        return cuentaDao.find(id);
    }

    //private void establecerCuentasSoportadas(){}

}
