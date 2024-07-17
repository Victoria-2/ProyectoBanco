package ar.utn.frbb.tup.model;

public enum TipoPersona {
    PERSONA_FISICA("F"),
    PERSONA_JURIDICA("J");

    private final String descripcion;
    TipoPersona(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public static TipoPersona fromString(String texto) throws IllegalAccessException {
        for (TipoPersona tipo : TipoPersona.values()){
            if(tipo.descripcion.equalsIgnoreCase(texto)){
                return tipo;
            }
        }
        throw new IllegalAccessException("TipoPersona invalido, "+texto+"no fue encontrado");
    }
}
