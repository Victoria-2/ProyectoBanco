package ar.utn.frbb.tup.persistence;

import org.springframework.stereotype.Component;

@Component
public class PrestamoDao extends AbstractBaseDao{
    @Override
    protected String getEntityType() {
        return "PRESTAMO";
    }

    public void almacenarDatosPrestamo(){}
}
