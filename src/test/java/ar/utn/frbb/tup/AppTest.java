package ar.utn.frbb.tup;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Direccion;
import ar.utn.frbb.tup.model.Monedas;
import ar.utn.frbb.tup.model.Persona;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.presentation.input.MenuInput;
import ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones.ConsultaDeSaldo;
import ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones.Deposito;
import ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones.IngresarDinero;
import ar.utn.frbb.tup.service.movimientos.TiposDeOperaciones.Retiro;

/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;*/

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /*@Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }*/

    //quise poner JUnit 5 pero tenia errores porque no encontraba carpetas para importar los assertions :( , esta comentado en el pom

    /*@Test
    public void testeoCrearImprimirPersona(){
        Persona persona1 = new Persona();
        persona1.setDni(45423402);
        Direccion dire1 = new Direccion("Alvarado", 111, "Bahia Blanca");
        persona1.setDireccion(dire1);
        System.out.println(persona1);

        Cliente cliente1 = new Cliente(persona1);
        System.out.println(cliente1);

    }

    @Test
    public void verificarGeneracionCBU(){
        Persona persona2 = new Persona();
        persona2.setNombre("Victoria");

        Direccion dire2 = new Direccion("Alvarado", 111, "Bahia Blanca");
        persona2.setDireccion(dire2);

        Cliente cliente2 = new Cliente(persona2);
        System.out.println(cliente2);

       CuentaBancaria primeraCuenta =  new CuentaBancaria(cliente2);
       System.out.println(primeraCuenta);
    }

    @Test
    public void generarCuentaBancaria(){
        Persona persona3 = new Persona();
        persona3.setNombre("Estela");
        persona3.setDni(33555666);

        Direccion dire3 = new Direccion("Saavedra", 259, "Punta Alta");
        persona3.setDireccion(dire3);

        Cliente cliente3 = new Cliente(persona3);

        Monedas peso = Monedas.valueOf("PESO_ARGENTINO");
        TipoDeCuenta corriente = TipoDeCuenta.valueOf("CUENTA_CORRIENTE");

       CuentaBancaria segundaCuenta =  new CuentaBancaria(cliente3,peso,corriente);
       System.out.println(segundaCuenta);
    }*/

    /*@Test
    public void obtencionSaldo(){
        Persona persona4 = new Persona();
        persona4.setNombre("Estela");
        persona4.setDni(356);

        Direccion dire4 = new Direccion("Alsina", 9, "BB");
        persona4.setDireccion(dire4);

        Cliente cliente4 = new Cliente(persona4);

        Monedas peso = Monedas.valueOf("PESO_ARGENTINO");
        TipoDeCuenta corriente = TipoDeCuenta.valueOf("CUENTA_CORRIENTE");

       CuentaBancaria cuartaCuenta =  new CuentaBancaria(cliente4,peso,corriente);
       System.out.println(cuartaCuenta);

        cuartaCuenta.setSaldo(25.33);

       System.err.println("\n"+cuartaCuenta.getSaldo());*/

       /*ConsultaDeSaldo consultar1 = new ConsultaDeSaldo();
       System.out.println("\n"+consultar1.consultarSaldo(cuartaCuenta));*/

       /*Movimiento m = new Movimiento(cuartaCuenta);
       m.generarConsultaSaldo();
       m.guardarMovimiento();*/
       //System.out.println(m); //tal vez seria mejor generar un metodo 'Imprimir()'
       //m.toString();
       /*cuartaCuenta.setMoimientosRealizados(m);
       m.generarConsultaSaldo();
       cuartaCuenta.setMoimientosRealizados(m);*/
        /*System.out.println(cuartaCuenta.getMoimientosRealizados());

        System.out.println(cliente4.getCuentasBancariasCliente());

    }*/

    /*@Test
    public void ConsultaDeSaldo2(){
        Persona persona4 = new Persona();
        persona4.setNombre("Estela");
        persona4.setDni(356);

        Direccion dire4 = new Direccion("Alsina", 9, "BB");
        persona4.setDireccion(dire4);

        Cliente cliente4 = new Cliente(persona4);

        Monedas peso = Monedas.valueOf("PESO_ARGENTINO");
        TipoDeCuenta corriente = TipoDeCuenta.valueOf("CUENTA_CORRIENTE");

       CuentaBancaria cuartaCuenta =  new CuentaBancaria(cliente4,peso,corriente);
       //System.out.println(cuartaCuenta);

        cuartaCuenta.setSaldo(25.33);
        ConsultaDeSaldo saldo = new ConsultaDeSaldo();
        System.out.println(saldo.generarConsultaSaldo(cuartaCuenta));

        System.out.println(cuartaCuenta.getMovimientosRealizados());
    }*/

    @Test
    public void testeoDeOperaciones(){
        Direccion dire5 = new Direccion("Cafe Leblanc", 5, "Tokio");
        Persona persona5 = new Persona("Ren","Amamiya",dire5, 1544556238, 38123456);
        Cliente cliente5 = new Cliente(persona5);
        Persona persona6 = new Persona("Francisco","Rodriguez",dire5, 1455693298, 235689741);
        Cliente cliente6 = new Cliente(persona6);

        Monedas  yen = Monedas.valueOf("YEN");
        TipoDeCuenta corriente = TipoDeCuenta.valueOf("CAJA_DE_AHORROS");

        CuentaBancaria quintaCuenta = new CuentaBancaria(cliente5, "yen", "corriente");
        CuentaBancaria sextaCuenta = new CuentaBancaria(cliente6, "yen", "corriente");

        ConsultaDeSaldo saldo = new ConsultaDeSaldo();
        //System.out.println(saldo.generarConsultaSaldo(quintaCuenta));

        IngresarDinero ingresoDinero = new IngresarDinero();
        ingresoDinero.generarIngresarDinero(quintaCuenta,5000);
        System.out.println(saldo.generarConsultaSaldo(quintaCuenta));
        ingresoDinero.generarIngresarDinero(sextaCuenta,2360);
        System.out.println(saldo.generarConsultaSaldo(sextaCuenta));

        System.out.println(quintaCuenta.getMovimientosRealizados());
        //System.out.println(sextaCuenta);
        //System.out.println(sextaCuenta.getSaldo());
        System.out.println(sextaCuenta.getMovimientosRealizados());

        Deposito hacerDeposito = new Deposito();
        hacerDeposito.generarDeposito(quintaCuenta, 1000, sextaCuenta);

        /*System.out.println(saldo.generarConsultaSaldo(quintaCuenta));
        System.out.println(saldo.generarConsultaSaldo(sextaCuenta));

        System.out.println(quintaCuenta.getMovimientosRealizados());*/
        /*Retiro retirarDinero = new Retiro();
        retirarDinero.generarRetirarDinero(sextaCuenta, 1500.6);
        System.out.println(saldo.generarConsultaSaldo(sextaCuenta));
        System.out.println(sextaCuenta.getMovimientosRealizados());*/
        
    }

    /*@Test
    public void testeoMenu(){
        Banco banco = new Banco();

        MenuInput menuInputProcessor = new MenuInput();
        menuInputProcessor.generarMenu(banco);
    }*/ /*fijarme si cambiando que muestra la terminal se puede usar JUnit 5.9.5 */

    /*PARA SEPARAR: es poner el nombre el archivo con y al final 'testeo' y adentro hacer los test de
     todas ESA clase*/ /*mvn test-compile test en temrinal*/

    
}
