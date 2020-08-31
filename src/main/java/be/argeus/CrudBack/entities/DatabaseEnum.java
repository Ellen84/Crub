package be.argeus.CrudBack.entities;

import java.io.Serializable;

/**
 * This interface needs to be implemented by enums for storing in the database, it works together with the DatabaseEnumConverter.
 *
 * @param <T> The Type to store in the database
 */
public interface DatabaseEnum<T> extends Serializable {
    /**
     * Return the value to be stored in the database
     *
     * @return The value to store in the database for this enum entry
     */
    T getValue();
}
