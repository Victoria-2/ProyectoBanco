package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    //atributos
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate nacimiento;

    //metodo constructor
    public Persona(){}
    public Persona(String nombre, String apellido, int dni, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = LocalDate.parse(nacimiento);
    }

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

    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        LocalDate fechaHoy = LocalDate.now();
        Period edad = Period.between(nacimiento, fechaHoy);
        return edad.getYears();
    }

}
