package ar.utn.frbb.tup.entidades;

import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Date;
import java.util.Random;

//import org.apache.commons.lang3.time.DateUtils;

public class CuentaBancaria {
    private Cliente clienteAsociadoCuenta;
    private String cbu; //este es el id -- en vez de 22 num son 20
    private Monedas moneda;
    private TipoDeCuenta tipoDeCuenta;
    private double saldo;
    private LocalDate fechaApertura;
    //private <list> movimientosRealizados
    private boolean estado;

    //metodos constructores
    public CuentaBancaria(Cliente cliente){
        this.clienteAsociadoCuenta = cliente;
        this.cbu = generarCbu();
        this.saldo = 0.0;
        this.fechaApertura = generarFechaApertura();
        //lista de movimientos realizados q este inicializada
        this.estado = true;

        //y agregar la cuenta bancaria a la lista de cuentas del cliente
    }

    public CuentaBancaria(Cliente cliente, Monedas moneda, TipoDeCuenta tipoDeCuenta){
        this.clienteAsociadoCuenta = cliente;
        this.cbu = generarCbu();
        this.moneda = moneda;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = 0.0;
        this.fechaApertura = generarFechaApertura();
        //lista de movimientos realizados q este inicializada
        this.estado = true;

        //agregar esta cuenta a la lista de cuentas del cliente
    }

    //metodos

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

    //REALIZAR MOVIMIENTO --no quiero q algo mas fuera de esta cuenta bancaria haga movimientos, por eso private
    private void realizarMovimiento(){

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
        return "CuentaBancaria [clienteAsociadoCuenta=" + clienteAsociadoCuenta + ", cbu=" + cbu + ", moneda=" + moneda
                + ", tipoDeCuenta=" + tipoDeCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura
                + ", estado=" + estado + "]";
    }


}
