package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.Random;

import ar.utn.frbb.tup.controller.CuentaBancariaDto;

public class CuentaBancaria {
    private Cliente titular;
    private String cbu;
    private LocalDate fechaApertura;
    private TipoDeCuenta tipoCuenta;
    private TipoMoneda moneda;
    private double saldo;

    //metodos constructores
    public CuentaBancaria(){
        this.cbu = generarCbu();
        this.fechaApertura = generarFechaApertura();
        this.saldo = 0.0;
    }
    public CuentaBancaria(CuentaBancariaDto cuentaBancariaDto){ //fijarme para ver is hay q poner el titular aca o no
        this.tipoCuenta = TipoDeCuenta.fromString(cuentaBancariaDto.getTipoCuenta());
        this.moneda = TipoMoneda.fromString(cuentaBancariaDto.getMoneda());
        this.fechaApertura = generarFechaApertura();
        this.saldo = 0.0;
        this.cbu = generarCbu();
    }

    //-----------------------------------
    //metodos
    
    //TITULAR
    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    //CBU
    private String generarCbu(){
        String numerosDelCbu = " ";
        for (int i = 0; i < 2; i++) {
            Random numeroRandom = new Random();
            String numDeCincoEspacios = String.format("%05d", numeroRandom.nextInt(10001));
            numerosDelCbu += numDeCincoEspacios;
        }
        return numerosDelCbu;
    }
    public String getCbu(){
        return this.cbu;
    }

    //GENERAR FECHA APERTURA
    private LocalDate generarFechaApertura(){
        return LocalDate.now();
    }
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(LocalDate fechaApertura){
        this.fechaApertura = fechaApertura;
    }

    //SALDO
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo){
        this.saldo= saldo;
    }
    //aca hay un metodo para debitar cuenta, se llama 'debitarDeCuenta'

    //TIPO CUENTA
    public TipoDeCuenta getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(TipoDeCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    //MONEDA
    public TipoMoneda getMoneda() {
        return moneda;
    }
    public void setMoneda(TipoMoneda moneda) {
        this.moneda = moneda;
    }

}  
