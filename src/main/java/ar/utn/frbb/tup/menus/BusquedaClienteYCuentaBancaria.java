package ar.utn.frbb.tup.menus;

import java.util.ArrayList;
import java.util.HashMap;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.entidades.Cliente;
import ar.utn.frbb.tup.entidades.CuentaBancaria;

///import ar.utn.frbb.tup.entidades.Cliente;
//import ar.utn.frbb.tup.entidades.CuentaBancaria;

public class BusquedaClienteYCuentaBancaria extends Menu{
    private Cliente clienteEncontrado;
    private CuentaBancaria cuentaBancariaEncontrada;

    //constructores
    BusquedaClienteYCuentaBancaria(){}

    public void buscarCliente(Banco banco){
        System.out.println("Por cuestiones de seguridad, ingrese su DNI para comenzar la operacion:");
        int buscarDNI = sc.nextInt();
        Cliente cliente = (Cliente) (banco.getUsuariosRegistrados()).get(buscarDNI); 
    }

    public void buscarCuentaBancaria(Cliente cliente){
        System.out.println("Decida desde cual de sus cuentas quiere operar:");
        HashMap hashmapDeCuentasBancariasCliente = cliente.getCuentasBancariasCliente();

        ArrayList<CuentaBancaria> listaDeCuentasBancariasCliente = new ArrayList<CuentaBancaria>(hashmapDeCuentasBancariasCliente.values());

        for (int i = 0; i < hashmapDeCuentasBancariasCliente.size(); i++) {
            System.out.println(i + " " + listaDeCuentasBancariasCliente.get(i));
        }

        int opcionCuentaBancaria = sc.nextInt();
        CuentaBancaria seleccionCuentaBancariaAOperar = listaDeCuentasBancariasCliente.get(opcionCuentaBancaria);

        System.out.println(seleccionCuentaBancariaAOperar);


       /*for (int i = 0; i < hashmapDeCuentasBancariasCliente.size(); i++) {
            System.out.println(i + " " + hashmapDeCuentasBancariasCliente.values());
        }*/
        //listaDeCuentasBancariasCliente.add(hashmapDeCuentasBancariasCliente.values());
        //System.out.println(cliente.getCuentasBancariasCliente());
        /*for (HashMap cuentasBancarias : listaDeCuentasBancariasCliente.values()) {
            
        }*/

        //Q ME DEVUELVA LAS CUENTAS DEL CLIENTE Y LUEGO SE ELIGE DESDE CUAL SE REALIZA LA OPERACION Y CHAU(!!!!)

        //CuentaBancaria cuentaBancaria = (CuentaBancaria) (banco.getCuentasRegistradas()).getValue((((CuentaBancaria) banco.getCuentasRegistradas()).getClienteAsociadoCuenta())== cliente);
        //CuentaBancaria cuenta = (CuentaBancaria) (banco.getCuentasRegistradas()).get(((cliente.getCuentasBancariasCliente()).getValue(cliente)).getCbu());
    }
}
