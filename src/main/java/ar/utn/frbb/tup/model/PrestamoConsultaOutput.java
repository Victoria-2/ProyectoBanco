package ar.utn.frbb.tup.model;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class PrestamoConsultaOutput {
    private double monto;
    private int plazoMeses;
    private int pagosRealizados;
    private double saldoRestante;

    public PrestamoConsultaOutput(Prestamo prestamo){
        this.monto = prestamo.getMontoPrestamo();
        this.plazoMeses = prestamo.getPlazoMeses();
        this.pagosRealizados = calcularPagosRealizados(prestamo.getPlanPagos());
        this.saldoRestante = calcularSaldoRestante(prestamo);
    }

    private int calcularPagosRealizados(List<Cuota> cuotasPrestamo){
        int cantCuotas = 0;
        for (Cuota cuota : cuotasPrestamo) {
            cantCuotas =+ 1;
        }
        return cantCuotas;
    }

    private double calcularSaldoRestante(Prestamo prestamo){
        double saldoTotal = prestamo.getMontoPrestamo() + prestamo.getInteresTotal();
        double saldoActual = ( prestamo.getPlanPagos().get(0).getMonto() ) * this.pagosRealizados;

        return saldoTotal - saldoActual;

    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
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
