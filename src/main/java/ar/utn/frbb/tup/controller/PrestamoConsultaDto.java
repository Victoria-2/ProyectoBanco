package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoConsultaDto {
    private long numeroCliente;
    private List<PrestamoConsultaCliente> prestamos = new ArrayList<PrestamoConsultaCliente>();

    public PrestamoConsultaDto(long dni){
        this.numeroCliente = dni;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }
    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<PrestamoConsultaCliente> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(List<PrestamoConsultaCliente> prestamos) {
        this.prestamos = prestamos;
    }
    public void addPrestamos(PrestamoConsultaCliente prestamo){
        this.prestamos.add(prestamo);
    }



    public static class PrestamoConsultaCliente {
        private double monto;
        private double intereses;
        private int plazoMeses;
        private int pagosRealizados;
        private double saldoRestante;

        public PrestamoConsultaCliente(Prestamo prestamo) {
            this.monto = prestamo.getMontoPrestamo();
            this.plazoMeses = prestamo.getPlazoMeses();
            this.intereses = prestamo.getInteresTotal();
        }

        public double getMonto() {
            return monto;
        }
        public void setMonto(double monto) {
            this.monto = monto;
        }

        public double getIntereses() {
            return intereses;
        }
        public void setIntereses(double intereses) {
            this.intereses = intereses;
        }

        public int getPlazoMeses() {
            return plazoMeses;
        }
        public void setPlazoMeses(int plazoMeses) {
            this.plazoMeses = plazoMeses;
        }

        public int getPagosRealizados() {
            return pagosRealizados;
        }
        public void setPagosRealizados(int pagosRealizados) {
            this.pagosRealizados = pagosRealizados;
        }

        public double getSaldoRestante() {
            return saldoRestante;
        }
        public void setSaldoRestante(double saldoRestante) {
            this.saldoRestante = saldoRestante;
        }

    }
}
