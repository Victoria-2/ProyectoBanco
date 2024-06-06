package ar.utn.frbb.tup.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Banco;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.Menu;

///import ar.utn.frbb.tup.entidades.Cliente;
//import ar.utn.frbb.tup.entidades.CuentaBancaria;

public class BusquedaClienteYCuentaBancaria extends Menu{
    private Cliente clienteEncontrado;
    private CuentaBancaria cuentaBancariaEncontrada;

    //constructores
    public BusquedaClienteYCuentaBancaria(){}


    //getters
    public Cliente getClienteEncontrado() {
        return clienteEncontrado;
    }
    public CuentaBancaria getCuentaBancariaEncontrada() {
        return cuentaBancariaEncontrada;
    }

    //metodos
    public Cliente buscarCliente(Banco banco, int dni){
        Cliente cliente = (Cliente) (banco.getUsuariosRegistrados()).get(dni); 
        clearScreen();

        this.clienteEncontrado = cliente;

        return cliente;
    } 

    public CuentaBancaria buscarCuentaBancaria(){
        System.out.println("Decida desde cual de las cuentas desea operar:");
        HashMap hashmapDeCuentasBancariasCliente = clienteEncontrado.getCuentasBancariasCliente();

        ArrayList<CuentaBancaria> listaDeCuentasBancariasCliente = new ArrayList<CuentaBancaria>(hashmapDeCuentasBancariasCliente.values());

        for (int i = 0; i < hashmapDeCuentasBancariasCliente.size(); i++) {
            System.out.println(i + " " + listaDeCuentasBancariasCliente.get(i));
        }

        int opcionCuentaBancaria = sc.nextInt();
        CuentaBancaria seleccionCuentaBancariaAOperar = listaDeCuentasBancariasCliente.get(opcionCuentaBancaria);

        //System.out.println(seleccionCuentaBancariaAOperar);

        clearScreen();

        this.cuentaBancariaEncontrada = seleccionCuentaBancariaAOperar;

        return seleccionCuentaBancariaAOperar;
    }
}
