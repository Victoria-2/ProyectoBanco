package ar.utn.frbb.tup.controller;

import java.time.LocalDate;

public class PersonaDto {
    private String nombre; //!
    private String apellido;  //!
    //private Direccion direccion;
    //private String numTelefono;
    private int dni; //!
    private String nacimiento; //!
    // private String email;

    //metodo constructor
    /*public PersonaDto(){}
    public PersonaDto(String nombre, String apellido, int dni, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = nacimiento;
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

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
}
