package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.Calendar;
//import java.util.Date;
import java.util.Random;

import ar.utn.frbb.tup.controller.CuentaBancariaDto;
import ar.utn.frbb.tup.model.movimientos.Movimiento;
import org.springframework.cglib.core.Local;

//import org.apache.commons.lang3.time.DateUtils;

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
    public CuentaBancaria(CuentaBancariaDto cuentaBancariaDto){
        this.fechaApertura = generarFechaApertura();
        //aca hay algo de tipo cuenta (??
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
        for (int i = 0; i < 4; i++) {
            Random numeroRandom = new Random();
            String numDeCincoEspacios = String.format("%04d", numeroRandom.nextInt(10001));
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
        //aca habia puesto el profe un return, pero creo que era para hacer sets uno atras del otro
    }

    //MONEDA
    public TipoMoneda getMoneda() {
        return moneda;
    }
    public void setMoneda(TipoMoneda moneda) {
        this.moneda = moneda;
    }

}  
