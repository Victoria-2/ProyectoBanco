package ar.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class PrestamoConsulta {
    private long numeroCliente;
    private List<PrestamoConsultaOutput> prestamos = new ArrayList<PrestamoConsultaOutput>();

    public PrestamoConsulta(long dni){
        this.numeroCliente = dni;
    }

    public long getNumeroCliente() {
        return numeroCliente;
    }
    public void setNumeroCliente(long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<PrestamoConsultaOutput> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(List<PrestamoConsultaOutput> prestamos) {
        this.prestamos = prestamos;
    }
    public void addPrestamos(PrestamoConsultaOutput prestamo){
        this.prestamos.add(prestamo);
    }




}
