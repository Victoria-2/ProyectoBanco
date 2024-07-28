package ar.utn.frbb.tup.presentationNO;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;

import java.util.HashMap;

public class Banco {
    private String nombre;
    private HashMap<Integer, Cliente> usuariosRegistrados = new HashMap<>();
    private HashMap<String, CuentaBancaria> cuentasRegistradas = new HashMap<>();

    
    //metodos constructores
    public Banco(){}
    Banco(String nombre){
        this.nombre = nombre;
    }
    //metodos

    //NOMBRE
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //USUARIOS REGISTRADOS
    public void agregarUsuarios(int dni, Cliente cliente){
        usuariosRegistrados.put(dni, cliente);
    }

    public HashMap getUsuariosRegistrados(){
        return usuariosRegistrados;
    }
    
    //CUENTAS REGISTRADAS
    public void agregarCuentas(String cbu, CuentaBancaria cuenta){
        cuentasRegistradas.put(cbu, cuenta);
    }

    public HashMap getCuentasRegistradas(){
        return cuentasRegistradas;
    }

}
