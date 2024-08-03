package ar.utn.frbb.tup.model;

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
    public void addPlanPagos(Cuota cuota) {
        planPagos.add(cuota);
    }
}
