package ar.utn.frbb.tup.model;

public enum TipoMoneda {
    DOLAR("USD"),
    PESO_ARGENTINO("ARS");

    private final String descripcion;
    TipoMoneda(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public static TipoMoneda fromString(String texto) throws IllegalAccessException {
        for (TipoMoneda tipo : TipoMoneda.values()){
            if(tipo.descripcion.equalsIgnoreCase(texto)){
                return tipo;
            }
        }
        throw new IllegalAccessException("TipoMoneda invalido, "+texto+" no fue encontrado");
    }
}
