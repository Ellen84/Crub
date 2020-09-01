package be.argeus.CrudBack.services;

import be.argeus.CrudBack.entities.PersonEntity;
import be.argeus.CrudBack.exceptions.DuplicateEntityException;
import be.argeus.CrudBack.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PersonService extends FindById {
        /**
         * Returns all projects.
         *
         * @return all projects
         */
        List<PersonEntity> findAll();

        /**
         * Creates a new project based on the provided {@link PersonEntity}.
         *
         * @param projectDto project data
         * @return the created entity
         */
        PersonEntity create(PersonEntity projectDto) throws DuplicateEntityException;

        /**
         * Deletes the project associated with the id.
         *
         * @param id must not be {@literal null}.
         * @throws EntityNotFoundException when no associated project is found.
         */
        void delete(long id) throws EntityNotFoundException;

        /**
         * Checks if the project id exists in the database.
         *
         * @param id must not be {@literal null}.
         * @return {@literal true} if an project with the given id exists, {@literal false} otherwise.
         */
        boolean existsById(long id);

        /**
         * Retrieves an project by its id.
         *
         * @param id must not be {@literal null}.
         * @return the project with the given id or {@literal Optional#empty()} if none found
         */
        Optional<PersonEntity> findById(long id);

        PersonEntity update(PersonEntity fromRest) throws DuplicateEntityException;
}
