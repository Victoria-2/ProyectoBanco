package ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.movimientos.Movimiento;
import ar.utn.frbb.tup.entidades.movimientos.Operacion;

public class Retiro extends Operacion{
    /*public Retiro(CuentaBancaria cuenta, double dinero){
        Resta retiro = new Resta(cuenta, dinero);
    }*/

    public Retiro(){
        this.setTipoDeOperacion("Retiro de Dinero");
    }

    public void generarRetirarDinero(CuentaBancaria cuenta, double dinero){
        Movimiento movimiento = new Movimiento(cuenta);
        movimiento.setTipoDeMovimiento(this.tipoDeOperacion);
        movimiento.setMonto(dinero);

        Resta retiro = new Resta(cuenta, dinero);

        movimiento.guardarMovimiento(cuenta);
    }
}
