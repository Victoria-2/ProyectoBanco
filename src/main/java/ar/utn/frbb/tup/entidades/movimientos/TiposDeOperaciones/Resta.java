package ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.entidades.CuentaBancaria;

public class Resta {
    Resta(CuentaBancaria cuenta, double monto){
        cuenta.setSaldo(monto - cuenta.getSaldo());
    }

    /*public double generarRestoSaldo(CuentaBancaria cuenta, double monto){
        
    }*/
}
