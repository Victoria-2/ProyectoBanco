package ar.utn.frbb.tup.entidades.movimientos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones.ConsultaDeSaldo;

public class Movimiento { //ES SOLO UN REGISTRO
    private LocalDate fecha;
    private LocalTime hora;
    private String idOperacion;
    private Operacion tipoDeMovimiento; //FIJARME MEJOR ESTA, tal vez un string
    private double monto;
    private /*String*/CuentaBancaria cuentasAGenerarMovimentos; // si son dos, la primera es la que deposita y la segunda la q recibe el dinero

    //metodos constructores
    public Movimiento(){
        generarFechaOperacion();
        generarHoraOperacion();
        generarIdOperacion();
    }
    public Movimiento(CuentaBancaria cuenta){
        generarFechaOperacion();
        generarHoraOperacion();
        generarIdOperacion();
        this.cuentasAGenerarMovimentos = cuenta;
    }
    

    //metodos

    //GUARDAR MOVIMIENTO
    private void guardarMovimiento(){
        //se agrega a la lista de la cuenta este movimiento
    }

    //ID OPERACION
    private void generarIdOperacion(){
        Random numeroRandom = new Random();
        String numDelId = String.format("%04d", numeroRandom.nextInt(1000000001));
        this.idOperacion = numDelId;
    }
    
    //HORA
    private void generarHoraOperacion(){
        LocalTime horaOperacion = LocalTime.now();
        this.hora = horaOperacion;
    }

    //FECHA
    private void generarFechaOperacion(){
        LocalDate diaDeHoy = LocalDate.now();
        this.fecha = diaDeHoy;
    }

    //CONSULTAR SALDO
    public double generarConsultaSaldo(/*CuentaBancaria cuentas*/){
        //this.cuentasAGenerarMovimentos = cuentas/*.getCBU()*/;
        ConsultaDeSaldo c = new ConsultaDeSaldo();
        this.tipoDeMovimiento = c;
        this.monto = c.consultarSaldo(cuentasAGenerarMovimentos);
        return this.monto;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Movimiento [fecha=" + fecha + ", hora=" + hora + ", tipoDeMovimiento=" + tipoDeMovimiento + ", Monto="
                + monto + ", idOperacion=" + idOperacion + ", cuentasAGenerarMovimentos=" + cuentasAGenerarMovimentos.getCBU()
                + "]"; //PENSAR MEJOR EL TO STRING  //tal vez seria mejor generar un metodo 'Imprimir()'
    }

    
    
}
