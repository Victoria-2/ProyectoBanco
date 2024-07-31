package ar.utn.frbb.tup.controller;

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
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
