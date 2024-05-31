package ar.utn.frbb.tup.model;

public class Direccion {
    //atributos
    protected String calle;
    protected int numeroCalle;
    protected String localidad;

    //metodo constructor
    public Direccion(){};
    public Direccion(String calle, int numeroCalle, String localidad){
        this.calle = calle;
        this.numeroCalle = numeroCalle;
        this.localidad = localidad;
    }

    //metodos
    public Direccion setDireccion(String calle, int num, String localidad) {
        this.calle = calle;
        this.numeroCalle = num;
        this.localidad = localidad;
        return this;
    }

    public String getDireccion(){
        return calle +" "+ numeroCalle +" "+ localidad;
    }

    //SETTERS
    public Direccion setCalle(String calle) {
        this.calle = calle;
        return this;
    }

    public Direccion setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
        return this;
    }

    public Direccion setLocalidad(String localidad) {
        this.localidad = localidad;
        return this;
    }


    //GETTERS
    public String getCalle() {
        return calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public String getLocalidad() {
        return localidad;
    }
    
    //IMPRIMIR
    @Override
    public String toString(){
        return this.calle+" "+this.numeroCalle+" -- "+this.localidad;
    }



}//fin clase
