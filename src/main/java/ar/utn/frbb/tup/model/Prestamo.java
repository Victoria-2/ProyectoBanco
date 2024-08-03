package ar.utn.frbb.tup.model;

import ar.utn.frbb.tup.controller.PrestamoDto;

public class Prestamo {
    private long numeroCliente;
    private int plazoMeses;
    private double montoPrestamo;
    private String moneda;

    public Prestamo(PrestamoDto prestamoDto) {
        this.numeroCliente = prestamoDto.getNumeroCliente();
        this.plazoMeses = prestamoDto.getPlazoMeses();
        this.montoPrestamo = prestamoDto.getMontoPrestamo();
        this.moneda = prestamoDto.getMoneda();
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }
    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }
    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }
    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
