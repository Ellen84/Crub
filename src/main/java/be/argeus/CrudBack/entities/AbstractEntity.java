package be.argeus.CrudBack.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !object.getClass().equals(getClass())) {
            return false;
        }
        Long objectId = ((AbstractEntity) object).getId();
        if (id == null) {
            return this == object;
        }
        return id.equals(objectId);
    }
}
