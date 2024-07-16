package ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.model.CuentaBancaria;

public class Suma {
    Suma(CuentaBancaria cuenta, double monto){
        cuenta.setSaldo(monto + cuenta.getSaldo());
    }
    
}
