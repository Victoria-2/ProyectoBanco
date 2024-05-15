package ar.utn.frbb.tup.entidades;

public class Persona {
    //atributos
    private String nombre;
    private String apellido; 
    private Direccion direccion; //Cuando se llame a direccion, generar el objeto en el menu!!
    private int numTelefono;
    private int dni;
    /*private char genero;
    private int nacimiento; //usarlo para chequear si es mayor o no
    private String email;*/

    //metodo constructor
    public Persona(){}
    Persona(String nombre, String apellido, Direccion direccion, int numTelefono, int dni){
        this.nombre = nombre;
    }

    //metodos

    //NOMBRE
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //APELLIDO
    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    //DIRECCION
    public Direccion getDireccion(){
        return this.direccion;
    }

    public void setDireccion(Direccion direccion){
        this.direccion = direccion;
    }

    //NUM TELEFONO
    public int getNumTelefono(){
        return this.numTelefono;
    }

    public void setNumTelefono(int numTelefono){
        this.numTelefono = numTelefono;
    }

    //DNI
    public int getDni(){
        return this.dni;
    }

    public void setDni(int dni){
        this.dni = dni;
    }

    //SOBREESCRIBIR EL TO STRING
    @Override
    public String toString() {
        return "\n Informacion de "+nombre+"\nNombre: " + nombre + "\nApellido: " + apellido + "\nDireccion:" + direccion + "\n numTelefono: "
                + numTelefono + "Dni: " + dni;
    }

    //IMPRIMIR
    /*public String imprimir(){
        return this.toString();
    }*/
}
