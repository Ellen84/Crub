package be.argeus.CrudBack.entities.rest;

public abstract class AbstractRest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
