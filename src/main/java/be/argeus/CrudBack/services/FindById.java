package be.argeus.CrudBack.services;

import java.util.Optional;

/**
 * Services that support findById(long) need to implement this method.
 */
public interface FindById<T> {
    Optional<T> findById(long id);
}
