package be.argeus.CrudBack.services.impl;

import be.argeus.CrudBack.entities.PersonEntity;
import be.argeus.CrudBack.exceptions.DuplicateEntityException;
import be.argeus.CrudBack.exceptions.EntityNotFoundException;
import be.argeus.CrudBack.repositories.PersonsRepository;
import be.argeus.CrudBack.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final ModelMapper mapper;
    private final PersonsRepository personsRepository;

    @Autowired
    public PersonServiceImpl(final ModelMapper mapper, final PersonsRepository personsRepository) {
        this.mapper = mapper;
        this.personsRepository = personsRepository;
    }

    @Override
    public List<PersonEntity> findAll() {
        return personsRepository.findAll();
    }

    @Override
    public PersonEntity create(final PersonEntity person) throws DuplicateEntityException {
        final PersonEntity newPerson = mapper.map(person, PersonEntity.class);

        final long newId = newPerson.getId();

        if (personsRepository.existsById(newId)) {
            throw new DuplicateEntityException(newId);
        }

        return personsRepository.save(newPerson);
    }

    @Override
    public void delete(final long id) throws EntityNotFoundException {
        if (!personsRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }

        personsRepository.deleteById(id);
    }

    @Override
    public boolean existsById(final long id) {
        if (id == 0) {
            return false;
        }

        return personsRepository.existsById(id);
    }

    @Override
    public Optional<PersonEntity> findById(final long id) {
        return personsRepository.findById(id);
    }

}
