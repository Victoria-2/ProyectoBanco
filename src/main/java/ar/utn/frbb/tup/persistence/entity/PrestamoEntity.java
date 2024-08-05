package ar.utn.frbb.tup.persistence.entity;

import ar.utn.frbb.tup.model.Cuota;
import ar.utn.frbb.tup.model.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoEntity extends BaseEntity{
    private Integer plazoMeses;
    private Double montoPrestamo;
    private String moneda;
    private String estado;
    private String mensaje;
    private List<Cuota> planPagos = new ArrayList<>();
    private Double interesTotal;

    public PrestamoEntity(Prestamo prestamo) {
        super((int)prestamo.getNumeroCliente());
        this.plazoMeses = prestamo.getPlazoMeses();
        this.montoPrestamo = prestamo.getMontoPrestamo();
        this.moneda = prestamo.getMoneda();
        this.estado = prestamo.getEstado();
        this.mensaje = prestamo.getMensaje();
        addCuotasPrestamo(prestamo);
        this.interesTotal = prestamo.getInteresTotal();
    }

    public Prestamo toPrestamo(){
        Prestamo prestamo = new Prestamo();
        prestamo.setNumeroCliente((long)super.getId());
        prestamo.setPlazoMeses(this.plazoMeses);
        prestamo.setMontoPrestamo(this.montoPrestamo);
        prestamo.setMoneda(this.moneda);
        prestamo.setEstado(this.estado);
        prestamo.setMensaje(this.mensaje);
        prestamo.setPlanPagos(this.planPagos);
        prestamo.setInteresTotal(this.interesTotal);
        return prestamo;
    }

    private void addCuotasPrestamo(Prestamo prestamo){
        if (prestamo.getPlanPagos() != null && !(prestamo.getPlanPagos().isEmpty())){
            planPagos.addAll(prestamo.getPlanPagos());
        }
    }


}
