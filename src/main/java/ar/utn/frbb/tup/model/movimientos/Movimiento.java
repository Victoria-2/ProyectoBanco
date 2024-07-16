package ar.utn.frbb.tup.model.movimientos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import ar.utn.frbb.tup.model.CuentaBancaria;

public class Movimiento { //ES SOLO UN REGISTRO, es como un ticket
    private LocalDate fecha;
    private LocalTime hora;
    private String idOperacion;
    private String tipoDeMovimiento; //FIJARME MEJOR ESTA, tal vez un string
    private double monto;

    //private /*String*/CuentaBancaria cuentasAGenerarMovimentos; // si son dos, la primera es la que deposita y la segunda la q recibe el dinero

    //metodos constructores
    public Movimiento(CuentaBancaria cuenta){
        generarFechaOperacion();
        generarHoraOperacion();
        generarIdOperacion();
    }
    public Movimiento(/*CuentaBancaria cuenta, */String tipoDeOperacion, double monto){
        generarFechaOperacion();
        generarHoraOperacion();
        generarIdOperacion();
        setTipoDeMovimiento(tipoDeOperacion);
        setMonto(monto);
        //this.cuentasAGenerarMovimentos = cuenta;
    }
    

    //metodos 

    //GUARDAR MOVIMIENTO
    public void guardarMovimiento(CuentaBancaria cuenta){
        cuenta.setMovimientosRealizados(this);
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

    //TIPO DE MOVIMIENTO
    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }
    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    //MONTO
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }


    //TO STRING
    @Override
    public String toString() {
        return "Movimiento [fecha=" + fecha + ", hora=" + hora + ", tipoDeMovimiento=" + tipoDeMovimiento + ", Monto="
                + monto + ", idOperacion=" + idOperacion +/*  ", cuentasAGenerarMovimentos=" + cuentasAGenerarMovimentos.getCBU()
                + */"]"; //PENSAR MEJOR EL TO STRING  //tal vez seria mejor generar un metodo 'Imprimir()'
    }

    
    
}
