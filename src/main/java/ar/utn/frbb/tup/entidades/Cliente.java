package ar.utn.frbb.tup.entidades;

import java.util.HashMap;

public class Cliente extends Persona {
    private int idCliente;
    private boolean estado; //si es true, es porque esta dada de alta, si es false esta dada de baja
    private Persona personaAsociadaCuenta; //hacer q se registre con su data y despues q se le cree el cliente
    private HashMap<String, CuentaBancaria> cuentasBancariasCliente = new HashMap<>();

    //metodos constructores
    public Cliente(){
        this.idCliente = super.getDni();
        altaCliente();
    }
    public Cliente(Persona personaDeLaCuenta){ //pensarlo mejor esto, conviene mas el super(nombre, apellido, ...)
        this.personaAsociadaCuenta = personaDeLaCuenta;
        this.idCliente = personaAsociadaCuenta.getDni();
        altaCliente();
    }

    //metodos

    //GUARDAR CUENTAS BANCARIAS
    public void setCuentasBancariasCliente(String CBU, CuentaBancaria cuentaBancaria){
        cuentasBancariasCliente.put(CBU, cuentaBancaria);
    }
    public HashMap getCuentasBancariasCliente(){
        return cuentasBancariasCliente;
    }

    //ALTA CLIENTE
    /*public void altaCliente(Persona persona){
        
    }*/
    private void altaCliente(){
        this.estado = true;
    }

    //MODIFICACION CLIENTE
        /*esto hacerlo con un menu y llamrlo aca */

    //BAJA CLIENTE
    private void BajaCliente(){
        this.estado = false;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Informacion Persona asociada:"+this.personaAsociadaCuenta+"Cliente [id=" + idCliente + ", estado=" + estado + "]";
    }

    
}
