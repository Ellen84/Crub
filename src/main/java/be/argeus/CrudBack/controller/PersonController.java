package be.argeus.CrudBack.controller;

import be.argeus.CrudBack.entities.PersonEntity;
import be.argeus.CrudBack.entities.rest.RestPerson;
import be.argeus.CrudBack.exceptions.DuplicateEntityException;
import be.argeus.CrudBack.exceptions.EntityNotFoundException;
import be.argeus.CrudBack.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController extends AbstractController<PersonEntity, RestPerson>{
    private final ModelMapper mapper;
    private final PersonService personService;

    @Autowired
    public PersonController(final ModelMapper mapper, final PersonService personService) {
        super(mapper, PersonEntity.class, RestPerson.class);
        this.mapper = mapper;
        this.personService = personService;
    }

    @GetMapping
    public List<RestPerson> index() {
        return personService.findAll().stream()
                .map(project -> mapper.map(project, RestPerson.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public RestPerson store(@Valid @RequestBody final RestPerson person) throws DuplicateEntityException {
        return toRest(personService.create(fromRest(person)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final String id) throws EntityNotFoundException {
        personService.delete(Long.parseLong(id));
    }

    @GetMapping ("/{id}")
    public RestPerson get(@PathVariable final String id)  throws EntityNotFoundException {
       return toRest(findByIdOrError(personService,Long.parseLong(id)));
    }
}

