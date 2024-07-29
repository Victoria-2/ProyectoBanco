package ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.movimientos.Movimiento;
import ar.utn.frbb.tup.model.movimientos.Operacion;

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
