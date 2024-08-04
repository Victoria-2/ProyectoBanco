package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.Cuota;

import java.util.ArrayList;
import java.util.List;

public class PrestamoOutput {
    private String estado;
    private String mensaje;
    private List<Cuota> planPagos = new ArrayList<>();

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Cuota> getPlanPagos() {
        return planPagos;
    }
    public void setPlanPagos(List<Cuota> planPagos) {
        this.planPagos = planPagos;
    }


}
