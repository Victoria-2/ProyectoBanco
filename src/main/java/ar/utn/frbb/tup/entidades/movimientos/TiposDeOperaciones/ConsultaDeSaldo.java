package ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones;
import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.movimientos.*;

public class ConsultaDeSaldo extends Operacion {
    //atributos

    //metodos constructores
    /*ConsultaDeSaldo() {
        super();
        
    }*/
    public ConsultaDeSaldo(){
        this.setTipoDeOperacion("Consulta de saldo");
    }
    
    //metodos

    public /*protected */ double consultarSaldo(CuentaBancaria cuenta){
        return cuenta.getSaldo();
    }


    
}
