package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.TipoPersona;

public class ClienteDto extends PersonaDto{
    private String bancoCliente;
    private String tipoPersona;

    //metodos
    public String getBancoCliente() {
        return bancoCliente;
    }
    public void setBancoCliente(String bancoCliente) {
        this.bancoCliente = bancoCliente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

}
