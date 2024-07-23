package ar.utn.frbb.tup.persistence.entity;


import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.model.TipoMoneda;

import java.time.LocalDate;

public class CuentaBancariaEntity extends BaseEntity{
    private Integer titular;
    private String cbu;
    private LocalDate fechaApertura;
    private String tipoCuenta;
    private String moneda;
    private double saldo;

    public CuentaBancariaEntity(CuentaBancaria cuenta){
        super(Integer.parseInt(cuenta.getCbu()));
        this.titular = cuenta.getTitular().getDni();
        this.fechaApertura = cuenta.getFechaApertura();
        this.tipoCuenta = cuenta.getTipoCuenta().toString(); //es mas conveniente y facil para la base de datos pasarlo a string que un enum
        this.moneda = cuenta.getMoneda().toString();
        this.saldo = cuenta.getSaldo();
    }

    public CuentaBancaria toCuentaBancaria(){
        CuentaBancaria cuenta = new CuentaBancaria();
        //cuenta.setTitular(); // NO ENTIENDO XQ NO PASA EL TITULAR ?????!!! xq tiene el id q es el del titular
        cuenta.setSaldo(this.saldo);
        cuenta.setFechaApertura(this.fechaApertura);
        cuenta.setTipoCuenta(TipoDeCuenta.valueOf(this.tipoCuenta));
        cuenta.setMoneda(TipoMoneda.valueOf(this.moneda));
        return cuenta;
    }

    public Integer getTitular() {
        return titular;
    }
}
