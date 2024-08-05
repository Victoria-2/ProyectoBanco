package ar.utn.frbb.tup.persistence;

import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.persistence.entity.PrestamoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrestamoDao extends AbstractBaseDao{
    public void almacenarDatosPrestamo(Prestamo prestamo){
        PrestamoEntity prestamoEntity = new PrestamoEntity(prestamo);
        getInMemoryDatabase().put(prestamoEntity.getId(), prestamoEntity);
    }

    public List<Prestamo> getPrestamosByCliente(Integer dni) {
        List<Prestamo> prestamosCliente = new ArrayList<Prestamo>();

        for (Object valor : getInMemoryDatabase().values()){
            if (valor.getClass().equals(PrestamoEntity.class)){
                PrestamoEntity prestamo = (PrestamoEntity) valor;
                if(prestamo.getId() == dni){
                    prestamosCliente.add(prestamo.toPrestamo());
                }
            }
        }

        return prestamosCliente;
    }

    @Override
    protected String getEntityType() {
        return "PRESTAMO";
    }

}
