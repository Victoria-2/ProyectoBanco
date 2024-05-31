package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.Calendar;
//import java.util.Date;
import java.util.Random;

import ar.utn.frbb.tup.service.Movimiento;

//import org.apache.commons.lang3.time.DateUtils;

public class CuentaBancaria {
    private Cliente clienteAsociadoCuenta;
    private String cbu; //este es el id -- en vez de 22 num son 20
    private /*Monedas*/ String moneda;
    private /*TipoDeCuenta*/ String tipoDeCuenta;
    private double saldo;
    private LocalDate fechaApertura;
    private Deque<Movimiento> movimientosRealizados = new ArrayDeque<>(); //me gusta porque puede ser fifo o lifo(!)
    private boolean estado;

    //metodos constructores
    public CuentaBancaria(Cliente cliente){
        this.clienteAsociadoCuenta = cliente;
        this.cbu = generarCbu();
        this.saldo = 0.0;
        this.fechaApertura = generarFechaApertura();
        this.estado = true;
        clienteAsociadoCuenta.setCuentasBancariasCliente(cbu, this);//aca guarda la cuenta ni bien se genera
    }

    public CuentaBancaria(Cliente cliente, /*Moneda*/String moneda, /*TipoDeCuenta*/ String tipoDeCuenta){
        this.clienteAsociadoCuenta = cliente;
        this.cbu = generarCbu();
        this.moneda = moneda;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = 0.0;
        this.fechaApertura = generarFechaApertura();
        this.estado = true;
        clienteAsociadoCuenta.setCuentasBancariasCliente(cbu, this);

        //agregar esta cuenta a la lista de cuentas del cliente
    }

    //metodos
    
    //CLIENTE ASOCIADO CUENTA
    public Cliente getClienteAsociadoCuenta() {
        return clienteAsociadoCuenta;
    }

    //CBU
    private String generarCbu(){
        String numerosDelCbu = " ";
        for (int i = 0; i < 4; i++) {
            Random numeroRandom = new Random();
            String numDeCincoEspacios = String.format("%04d", numeroRandom.nextInt(10001));
            numerosDelCbu += numDeCincoEspacios;
        }
        return numerosDelCbu;
    }
    public String getCBU(){
        return this.cbu;
    }

    public String getCbu(){
        return this.cbu;
    }

    //MOVIMIENTOS --no quiero q algo mas fuera de esta cuenta bancaria haga movimientos, por eso private
    /*private void realizarMovimiento(){

    }*/

    public Deque getMovimientosRealizados(){
        return movimientosRealizados;
    }

    public void setMovimientosRealizados(Movimiento movimiento){
        movimientosRealizados.offerLast(movimiento);
    }

    //GENERAR FECHA APERTURA
    private LocalDate/*Date*/ generarFechaApertura(){
        //Date diaDeHoy = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        //return diaDeHoy;
        LocalDate diaDeHoy = LocalDate.now();
        return diaDeHoy;
    }

    //SALDO
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo){
        this.saldo= saldo;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return /* "CuentaBancaria [clienteAsociadoCuenta=" + clienteAsociadoCuenta + ",*/ "["+"cbu=" + cbu + ", moneda=" + moneda
                + ", tipoDeCuenta=" + tipoDeCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura
                + /* ", estado=" + estado +*/ "]";
    }


}  