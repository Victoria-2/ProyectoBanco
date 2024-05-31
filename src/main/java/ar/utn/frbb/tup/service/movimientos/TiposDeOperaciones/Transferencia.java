package ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.service.Movimiento;
import ar.utn.frbb.tup.service.Operacion;

public class Transferencia extends Operacion{
    public Transferencia(){
        this.setTipoDeOperacion("Transferencia");
    }

    public void generarTransferencia(CuentaBancaria cuenta1, double dinero, CuentaBancaria cuenta2){
        Movimiento movimiento = new Movimiento(cuenta1);
        movimiento.setTipoDeMovimiento(this.tipoDeOperacion);
        movimiento.setMonto(dinero);

        Resta cuentaHaceDeposito = new Resta(cuenta1, dinero);
        Suma cuentaRecibeDeposito = new Suma(cuenta2, dinero);
        movimiento.guardarMovimiento(cuenta1);

        Movimiento movimiento2 = new Movimiento(cuenta2);
        movimiento2.setMonto(dinero);
        movimiento2.setTipoDeMovimiento("Transferencia recibida de cuenta "+cuenta1.getCBU());
        movimiento2.guardarMovimiento(cuenta2);
    }
    
}
