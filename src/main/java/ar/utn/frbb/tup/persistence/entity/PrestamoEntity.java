package ar.utn.frbb.tup.persistence.entity;

public class PrestamoEntity extends BaseEntity{
    public PrestamoEntity(int id) {
        super(id);
    }

    //hay que hacer un .toOutput y pasar nada mas el mensaje, las cuotas y el estado, q el resto quede null
}
