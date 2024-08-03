package ar.utn.frbb.tup.persistence;

import ar.utn.frbb.tup.model.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class PrestamoDao extends AbstractBaseDao{
    @Override
    protected String getEntityType() {
        return "PRESTAMO";
    }

    public Prestamo almacenarDatosPrestamo(Prestamo prestamo){

    }
}
