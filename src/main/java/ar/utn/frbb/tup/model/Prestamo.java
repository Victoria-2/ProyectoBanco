package ar.utn.frbb.tup.model;

import ar.utn.frbb.tup.controller.PrestamoDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long numeroCliente;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer plazoMeses;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double montoPrestamo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String moneda;

    private String estado;
    private String mensaje;
    private List<Cuota> planPagos = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL) //EN DUDA
    private Double interesTotal;

    public Prestamo(){}
    public Prestamo(PrestamoDto prestamoDto) {
        this.numeroCliente = prestamoDto.getNumeroCliente();
        this.plazoMeses = prestamoDto.getPlazoMeses();
        this.montoPrestamo = prestamoDto.getMontoPrestamo();
        this.moneda = prestamoDto.getMoneda();
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }
    public void setNumeroCliente(Long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }
    public void setPlazoMeses(Integer plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }
    public void setMontoPrestamo(Double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

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
    public void addCuota(Cuota cuota) {
        planPagos.add(cuota);
    }

    public double getInteresTotal() {
        return interesTotal;
    }
    public void setInteresTotal(Double interesTotal) {
        this.interesTotal = interesTotal;
    }

    public Prestamo toOutput(){
        this.setNumeroCliente(null);
        this.setPlazoMeses(null);
        this.setMontoPrestamo(null);
        this.setMoneda(null);
        this.setInteresTotal(null);
        return this;
    }

    //toConsulta

}
