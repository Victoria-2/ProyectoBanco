package ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.service.Movimiento;
import ar.utn.frbb.tup.service.Operacion;

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
