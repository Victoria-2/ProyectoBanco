package ar.utn.frbb.tup.persistence.entity;

public class BaseEntity {
    private final int Id;
    private final String cbu;
    public BaseEntity(int id) {
        Id = id;
        cbu = null;
    }
    public BaseEntity(String cbu) {
        Id = 0;
        this.cbu = cbu;
    }

    public int getId() {
        return Id;
    }
}
