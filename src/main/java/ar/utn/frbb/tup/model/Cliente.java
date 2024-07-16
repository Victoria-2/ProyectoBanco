package ar.utn.frbb.tup.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona {
    private String bancoCliente;
    private int id;
    private TipoPersona tipoPersona;
    private Set<CuentaBancaria> cuentasBancariasCliente = new HashSet<>();

    //-----------A CHEQUEAR
    //metodos constructores
    public Cliente(){
        this.id = super.getDni();
    }


    //metodos

    //GUARDAR CUENTAS BANCARIAS
    public void setCuentasBancariasCliente(String CBU, CuentaBancaria cuentaBancaria){
        cuentasBancariasCliente.put(CBU, cuentaBancaria);
    }
    public HashMap getCuentasBancariasCliente(){
        return cuentasBancariasCliente;
    }


    // TO STRING
    /*@Override
    public String toString() {
        return "Informacion Persona asociada:"+this.personaAsociadaCuenta+"Cliente [id=" + id + ", estado=" + estado + "]";
    }*/

    
}
