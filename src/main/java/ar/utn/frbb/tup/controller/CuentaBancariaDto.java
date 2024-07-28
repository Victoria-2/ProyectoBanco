package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.model.TipoMoneda;

public class CuentaBancariaDto {
    private int dniTitular;
    private String tipoCuenta;
    private String moneda;

    //setters y getters
    public int getDniTitular() {
        return dniTitular;
    }
    public void setDniTitular(int dniTitular) {
        this.dniTitular = dniTitular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(TipoDeCuenta tipoCuenta) {
        this.tipoCuenta = String.valueOf(tipoCuenta);
    }

    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(TipoMoneda moneda) {
        this.moneda = String.valueOf(moneda);
    }
}
