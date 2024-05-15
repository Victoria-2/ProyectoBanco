package ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones;

import ar.utn.frbb.tup.entidades.CuentaBancaria;

public class Suma {
    Suma(CuentaBancaria cuenta, double monto){
        cuenta.setSaldo(monto + cuenta.getSaldo());
    }
    
}
