package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.TipoPersona;

public class ClienteDto extends PersonaDto{
    private String bancoCliente;
    private TipoPersona tipoPersona;

    //metodos
    public String getBancoCliente() {
        return bancoCliente;
    }
    public void setBancoCliente(String bancoCliente) {
        this.bancoCliente = bancoCliente;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

}
