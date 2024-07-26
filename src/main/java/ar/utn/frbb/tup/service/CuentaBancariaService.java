package ar.utn.frbb.tup.service;

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


    public boolean tipoCuentaEstaSoportada(CuentaBancaria cuenta){ //A MEJORAR
        if((cuenta.getMoneda() == TipoMoneda.PESO_ARGENTINO) && (cuenta.getTipoCuenta() == TipoDeCuenta.CAJA_DE_AHORROS)){
            return true;
        } else if((cuenta.getMoneda() == TipoMoneda.DOLAR) && (cuenta.getTipoCuenta() == TipoDeCuenta.CAJA_DE_AHORROS)){
            return true;
        } else return (cuenta.getMoneda() == TipoMoneda.PESO_ARGENTINO) && (cuenta.getTipoCuenta() == TipoDeCuenta.CUENTA_CORRIENTE);
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

    public void darDeAltaCuenta(CuentaBancaria cuenta, int dniTitular) throws CuentaAlreadyExistsException, TipoCuentaAlreadyExistsException, CuentaNoSoportadaException, IllegalAccessException {
        if(cuentaDao.find(cuenta.getTitular().getDni()) != null) { //nes el dni
            throw new CuentaAlreadyExistsException("La cuenta con el dni " + cuenta.getTitular().getDni() + " ya existe");
        }

        //Chequear cuentas soportadas por el banco CA$ CC$ CAU$S
        if (!tipoCuentaEstaSoportada(cuenta)) {
            throw new CuentaNoSoportadaException("Ya posee una cuenta del tipo " + cuenta.getTipoCuenta());
        }

        clienteService.agregarCuenta(cuenta, dniTitular);
        cuentaDao.save(cuenta);
    }

    public CuentaBancaria find(int id) {
        return cuentaDao.find(id);
    }

    //private void establecerCuentasSoportadas(){}

}
