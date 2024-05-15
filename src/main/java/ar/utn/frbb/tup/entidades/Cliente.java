package ar.utn.frbb.tup.entidades;

public class Cliente extends Persona {
    private int idCliente;
    private boolean estado; //si es true, es porque esta dada de alta, si es false esta dada de baja
    private Persona personaAsociadaCuenta; //hacer q se registre con su data y despues q se le cree el cliente
    //private ArrayListy(???) - cuentas;

    //metodos constructores
    public Cliente(){
        this.idCliente = super.getDni();
        this.estado = true;
    }
    public Cliente(Persona personaDeLaCuenta){ //pensarlo mejor esto, conviene mas el super(nombre, apellido, ...)
        this.personaAsociadaCuenta = personaDeLaCuenta;
        this.idCliente = personaAsociadaCuenta.getDni();
        this.estado = true;
    }

    //metodos

    //ALTA CLIENTE
    /*public void altaCliente(Persona persona){
        
    }*/

    public void AltaCliente(){
        this.estado = true;
    }

    //MODIFICACION CLIENTE
        /*esto hacerlo con un menu y llamrlo aca */

    //BAJA CLIENTE

    public void BajaCliente(){
        this.estado = false;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Persona asociada:"+this.personaAsociadaCuenta+"Cliente [id=" + idCliente + ", estado=" + estado + "]";
    }

    
}
