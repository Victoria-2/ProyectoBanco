package ar.utn.frbb.tup.controller;

import jakarta.validation.constraints.NotNull;

public class PrestamoDto {
    @NotNull(message = "Debe ingresar el numero del cliente")
    private long numeroCliente;
    @NotNull(message = "Debe ingresar el plazo en el que desea pagar")
    private int plazoMeses;
    @NotNull(message = "Debe establecer el monto a solicitar")
    private double montoPrestamo;
    @NotNull(message = "Debe establecer la moneda del prestamo")
    private String moneda;

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

    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }
    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }
}
