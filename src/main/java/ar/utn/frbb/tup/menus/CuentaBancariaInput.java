package ar.utn.frbb.tup.menus;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.entidades.Cliente;
import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.Monedas;

public class CuentaBancariaInput extends Menu{
    
    public /*CuentaBancaria*/ void generarCuentaBancaria(Banco banco/*, Cliente cliente*/){
    
        System.out.println("Vamos a generar una Cuenta Bancaria!");
        System.out.println("Por cuestiones de seguridad, ingrese su DNI para comenzar la operacion:");
        int buscarDNI = sc.nextInt();
        Cliente cliente = (Cliente) (banco.getUsuariosRegistrados()).get(buscarDNI);  
        //System.out.println(cliente);

        System.out.println("Con que moneda desea operar?:");
        for (Monedas tipoDeMonedas : Monedas.values()) {
            System.out.println("\n"+tipoDeMonedas);
        }
        String monedaElegida = sc.next();

        System.out.println("Determine el tipo de cuenta que desea:");
        for (Monedas tipoDeMonedas : Monedas.values()) {
            System.out.println("\n"+tipoDeMonedas);
        }
        String tipoCuentaElegida = sc.next();


        CuentaBancaria cuentaB = new CuentaBancaria(cliente, monedaElegida, tipoCuentaElegida);
        banco.agregarCuentas(cuentaB.getCBU(), cuentaB);

        clearScreen();
        System.out.println("\n Su cuenta bancaria se ha registrado correctamente! Ya puede comenzar a operar!");
        clearScreen(2);

        //return cuentaBancaria;
    }



}
