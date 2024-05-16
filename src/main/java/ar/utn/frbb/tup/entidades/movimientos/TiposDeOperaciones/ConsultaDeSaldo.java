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

    public double simpleConsultaDeSaldo(CuentaBancaria cuenta){
        return cuenta.getSaldo();
    }

    public double generarConsultaSaldo(/*Movimiento movimiento, */CuentaBancaria cuenta){
        //this.cuentasAGenerarMovimentos = cuentas/*.getCBU()*/;
        //ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        //double consulta = simpleConsultaDeSaldo(cuenta);
        //Movimiento movimiento = new Movimiento(this.tipoDeOperacion, cuenta.getSaldo());}
        Movimiento movimiento = new Movimiento(cuenta);
        movimiento.setTipoDeMovimiento(this.tipoDeOperacion);
        movimiento.setMonto(cuenta.getSaldo());
        movimiento.guardarMovimiento(cuenta);
        return movimiento.getMonto();
    }


    //TO STRING
   /*  @Override
    public String toString() {
        return super.getTipoDeOperacion();
    }*/
    


    
}
