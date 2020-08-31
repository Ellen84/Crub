package be.argeus.CrudBack.exceptions;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(final Long id) {
        super("Entity with id: " + ObjectUtils.defaultIfNull(id, "<NULL>") + " cannot be found");
    }
}
