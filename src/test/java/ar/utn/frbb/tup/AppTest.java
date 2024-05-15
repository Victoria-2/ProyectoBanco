package ar.utn.frbb.tup;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.utn.frbb.tup.entidades.*;
import ar.utn.frbb.tup.entidades.movimientos.Movimiento;
import ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones.ConsultaDeSaldo;

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

    @Test
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

       System.err.println("\n"+cuartaCuenta.getSaldo());

       /*ConsultaDeSaldo consultar1 = new ConsultaDeSaldo();
       System.out.println("\n"+consultar1.consultarSaldo(cuartaCuenta));*/

       Movimiento m = new Movimiento();
       m.generarConsultaSaldo(cuartaCuenta);
    }
    
}
