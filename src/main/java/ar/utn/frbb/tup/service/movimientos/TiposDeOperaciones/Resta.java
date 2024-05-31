package ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;

public class Resta {
    Resta(CuentaBancaria cuenta, double monto){
        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }

    /*public double generarRestoSaldo(CuentaBancaria cuenta, double monto){
        
    }*/
}
