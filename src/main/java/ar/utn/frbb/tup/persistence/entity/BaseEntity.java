package ar.utn.frbb.tup.persistence.entity;

public class BaseEntity {
    private final int Id;
    public BaseEntity(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }
}
