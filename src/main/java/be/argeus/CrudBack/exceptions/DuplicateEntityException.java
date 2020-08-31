package be.argeus.CrudBack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.commons.lang3.ObjectUtils;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateEntityException extends Exception{
    public DuplicateEntityException(final Object id) {
        super("Entity with id: " + ObjectUtils.defaultIfNull(id, "<NULL>") + " already exists");
    }
}

