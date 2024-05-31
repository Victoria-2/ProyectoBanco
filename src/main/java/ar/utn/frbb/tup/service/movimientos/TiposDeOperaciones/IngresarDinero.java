package ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.service.Movimiento;
import ar.utn.frbb.tup.service.Operacion;

public class IngresarDinero extends Operacion { //tal vez hacer que cuando se cree el usuario 'detecte' q tiene una tarjeta y si quiere ingresar dinero a la cuenta
    /*public IngresarDinero(CuentaBancaria cuenta, double dinero){
        Suma ingreso = new Suma(cuenta, dinero);
    }*/
    public IngresarDinero(){
        this.setTipoDeOperacion("Ingreso de Dinero");
    }

    public void generarIngresarDinero(CuentaBancaria cuenta, double dinero){
        Movimiento movimiento = new Movimiento(cuenta);
        movimiento.setTipoDeMovimiento(this.tipoDeOperacion);
        movimiento.setMonto(dinero);

        Suma ingreso = new Suma(cuenta, dinero);

        movimiento.guardarMovimiento(cuenta);
    }
}
