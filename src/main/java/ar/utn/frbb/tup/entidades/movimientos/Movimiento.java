package ar.utn.frbb.tup.entidades.movimientos;

import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones.ConsultaDeSaldo;

public class Movimiento { //ES SOLO UN REGISTRO
    private int fecha;
    private int hora;
    private Operacion tipoDeMovimiento; //FIJARME MEJOR ESTA, tal vez un string
    private double Monto;
    private int idOperacion;
    private CuentaBancaria cuentasAGenerarMovimentos; // si son dos, la primera es la que deposita y la segunda la q recibe el dinero

    //metodos constructores
    public Movimiento(){
        
    }
    

    //metodos

    //GUARDAR MOVIMIENTO
    private void guardarMovimiento(){
        //se agrega a la lista de la cuenta este movimiento
    }

    //CONSULTAR SALDO
    public double generarConsultaSaldo(CuentaBancaria cuentas){
        ConsultaDeSaldo c = new ConsultaDeSaldo();
        return c.consultarSaldo(cuentas);
    }
    
}
