package ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.movimientos.Movimiento;
import ar.utn.frbb.tup.model.movimientos.Operacion;

public class Deposito extends Operacion{
    /*public Deposito(CuentaBancaria cuenta1, double dinero, CuentaBancaria cuenta2){
        Resta cuentaHaceDeposito = new Resta(cuenta1, dinero);
        Suma cuentaRecibeDeposito = new Suma(cuenta2, dinero);
    }*/

    public Deposito(){
        this.setTipoDeOperacion("Deposito");
    }

    public void generarDeposito(CuentaBancaria cuenta1, double dinero, CuentaBancaria cuenta2){
        Movimiento movimiento = new Movimiento(cuenta1);
        movimiento.setTipoDeMovimiento(this.tipoDeOperacion);
        movimiento.setMonto(dinero);

        Resta cuentaHaceDeposito = new Resta(cuenta1, dinero);
        Suma cuentaRecibeDeposito = new Suma(cuenta2, dinero);
        movimiento.guardarMovimiento(cuenta1);

        Movimiento movimiento2 = new Movimiento(cuenta2);
        movimiento2.setMonto(dinero);
       // movimiento2.setTipoDeMovimiento("Deposito recibido de cuenta "+cuenta1.getCBU());
        movimiento2.guardarMovimiento(cuenta2);
    }
}
