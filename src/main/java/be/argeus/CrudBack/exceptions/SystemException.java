package be.argeus.CrudBack.exceptions;

import java.util.Objects;
import java.util.Optional;

/**
 * A general RuntimeException.
 */
public class SystemException extends RuntimeException {
    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Throw a SystemException if two objects are not equal.
     *
     * @param check      True if ok, false if to throw exception
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     */
    public static void throwIfTrue(boolean check, String message, Object... parameters) {
        if (check) {
            throw new SystemException(String.format(message, parameters));
        }
    }

    /**
     * Throw a SystemException if two objects are not equal.
     *
     * @param check      True if ok, false if to throw exception
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     */
    public static void throwIfFalse(boolean check, String message, Object... parameters) {
        throwIfTrue(!check, message, parameters);
    }

    /**
     * Throw a SystemException if the object is null.
     *
     * @param object     The object to check
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     * @param <T>        The type of object
     * @return The original object
     */
    public static <T> T throwIfNull(T object, String message, Object... parameters) {
        throwIfTrue(object == null, message, parameters);
        return object;
    }

    /**
     * Throw a SystemException if the object is notnull.
     *
     * @param object     The object to check
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     * @param <T>        The type of object
     * @return The original object
     */
    public static <T> T throwIfNotNull(T object, String message, Object... parameters) {
        throwIfFalse(object == null, message, parameters);
        return object;
    }

    /**
     * Throw a SystemException if two objects are equal.
     *
     * @param object1    The object to check
     * @param object2    The object to compare to
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     * @param <T>        The type of object
     * @return The original object
     */
    public static <T> T throwIfEqual(T object1, T object2, String message, Object... parameters) {
        throwIfTrue(Objects.equals(object1, object2), message, parameters);
        return object1;
    }

    /**
     * Throw a SystemException if two objects are not equal.
     *
     * @param object1    The object to check
     * @param object2    The object to compare to
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     * @param <T>        The type of object
     * @return The original object
     */
    public static <T> T throwIfNotEqual(T object1, T object2, String message, Object... parameters) {
        throwIfFalse(Objects.equals(object1, object2), message, parameters);
        return object1;
    }

    /**
     * Throw a SystemException if a string is blank.
     *
     * @param string     The string to check
     * @param message    The message to use for the SystemException
     * @param parameters The parameters for the message
     * @return The original object
     */
    public static CharSequence throwIfBlank(CharSequence string, String message, Object... parameters) {
        throwIfTrue(string == null || "".equals(string.toString().trim()), message, parameters);
        return string;
    }

    /**
     * Throw a SystemException if an Optional is empty, return it's value otherwise.
     *
     * @param optional The optional to check
     * @param message  The message to use for the SystemException
     */
    public static <T> T throwIfEmpty(Optional<T> optional, String message) {
        throwIfFalse(optional.isPresent(), message);
        return optional.get();
    }
}
