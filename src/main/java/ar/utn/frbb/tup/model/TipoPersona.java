package ar.utn.frbb.tup.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoPersona {
    PERSONA_FISICA("F"),
    PERSONA_JURIDICA("J");

    private String descripcion;
    TipoPersona(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public static TipoPersona fromString(String texto) {
        for (TipoPersona tipo : TipoPersona.values()){
            if(tipo.descripcion.equalsIgnoreCase(texto)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("TipoPersona invalido, "+texto+" no fue encontrado");
    }
}
