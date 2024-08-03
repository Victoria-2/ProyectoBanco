package ar.utn.frbb.tup.persistence;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.persistence.entity.PrestamoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrestamoDao extends AbstractBaseDao{
    public void almacenarDatosPrestamo(Prestamo prestamo){
        PrestamoEntity prestamoEntity = new PrestamoEntity(prestamo);
        getInMemoryDatabase().put(prestamoEntity.getId(), prestamoEntity);
    }

    /*public List<CuentaBancaria> getPrestamosByCliente(Integer dni) {
    }*/

    @Override
    protected String getEntityType() {
        return "PRESTAMO";
    }

}
