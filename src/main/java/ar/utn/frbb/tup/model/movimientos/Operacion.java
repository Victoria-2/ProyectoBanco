package ar.utn.frbb.tup.model.movimientos;

public /*static*/ class Operacion {
    protected String tipoDeOperacion;


    //metodos constructores
    protected Operacion(){
        this.tipoDeOperacion = "Operacion";
    }
    /*protected Operacion(String tipoOperacion){
        this.tipoDeOperacion = tipoDeOperacion;
    }*/ //?

    //metodos

    //TIPO DE OPERACION
    protected String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    protected void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    
}
