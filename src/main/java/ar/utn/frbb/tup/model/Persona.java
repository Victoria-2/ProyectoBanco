package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    //atributos
    private String nombre; //!
    private String apellido;  //!
    //private Direccion direccion;
    //private String numTelefono;
    private int dni; //!
    private LocalDate nacimiento; //!
   // private String email;

    //metodo constructor
    public Persona(){}
    public Persona(String nombre, String apellido, int dni, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = LocalDate.parse(nacimiento);
    }
    /*public Persona(String apellido, String nombre, Direccion direccion, String numTelefono, int dni, LocalDate nacimiento, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.email = email;
    }*/

    //metodos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /*public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }*/

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    /*public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }*/

    //TO STRING
    /*@Override
    public String toString() {
        return "\n Informacion de "+nombre+"\nNombre: " + nombre + "\nApellido: " + apellido + "\nDireccion:" + direccion + "\n numTelefono: "
                + numTelefono + "Dni: " + dni;
    }*/

    //EDAD
    public int getEdad() {
        LocalDate fechaHoy = LocalDate.now();
        Period edad = Period.between(nacimiento, fechaHoy);
        return edad.getYears();
    }

}
