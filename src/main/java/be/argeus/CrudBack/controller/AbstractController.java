package be.argeus.CrudBack.controller;

import be.argeus.CrudBack.entities.DatabaseEnum;
import be.argeus.CrudBack.exceptions.SystemException;
import be.argeus.CrudBack.services.FindById;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Abstract RestController.
 *
 * @param <E> The type of service entity to control.
 * @param <R> The type of rest object to control.
 */
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public abstract class AbstractController<E, R> {
    protected final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<R> restClass;

    public AbstractController(ModelMapper modelMapper, Class<E> entityClass, Class<R> restClass) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.restClass = restClass;
    }

    protected E findByIdOrError(FindById<E> service, long id) {
        return SystemException.throwIfEmpty(service.findById(id), "Entity not found");
    }

    protected R toRest(E entity) {
        return modelMapper.map(entity, restClass);
    }

    protected E fromRest(R rest) {
        return fromRest(rest, null);
    }

    /**
     * Convert a rest DTO to an entity
     *
     * @param rest   The rest DTO
     * @param entity The target entity, or null if to create a new one
     * @return The updated or created entity
     */
    protected E fromRest(R rest, @Nullable E entity) {
        return map(rest, entityClass, entity);
    }

    protected <T> T map(Object object, Class<T> type) {
        return modelMapper.map(object, type);
    }

    /**
     * Convert a rest DTO to an entity
     *
     * @param object   The rest DTO
     * @param type     The type of the target entity
     * @param existing The target entity, or null if to create a new one
     * @return The updated or created entity
     */
    protected <T> T map(Object object, Class<T> type, T existing) {
        if (existing == null) {
            return modelMapper.map(object, type);
        }
        modelMapper.map(object, existing);
        return existing;
    }

    protected <D, T extends DatabaseEnum<D>> void addDatabaseEnumConverter(Class<T> enumType, Class<D> dataType) {
        Map<D, T> values = Arrays
                .stream(enumType.getEnumConstants())
                .collect(Collectors.toMap(DatabaseEnum::getValue, enu -> enu));
        modelMapper.addConverter(new AbstractConverter<T, D>() {
            @Override
            protected D convert(T source) {
                return source == null ? null : source.getValue();
            }
        }, enumType, dataType);
        modelMapper.addConverter(new AbstractConverter<D, T>() {
            @Override
            protected T convert(D source) {
                return source == null ? null : values.get(source);
            }
        }, dataType, enumType);
    }
}
