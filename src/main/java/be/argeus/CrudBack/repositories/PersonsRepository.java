package be.argeus.CrudBack.repositories;

import be.argeus.CrudBack.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository  extends JpaRepository<PersonEntity, Long> {
}
