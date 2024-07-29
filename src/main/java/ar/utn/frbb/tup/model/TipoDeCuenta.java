package ar.utn.frbb.tup.model;

public enum TipoDeCuenta {
    CAJA_DE_AHORROS("CA"),
    CUENTA_CORRIENTE("CC");

    private final String descripcion;
    TipoDeCuenta(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public static TipoDeCuenta fromString(String texto) {
        for (TipoDeCuenta tipo : TipoDeCuenta.values()){
            if(tipo.descripcion.equalsIgnoreCase(texto)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("TipoDeCuenta invalido, "+texto+"no fue encontrado");
    }
}
