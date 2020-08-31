package be.argeus.CrudBack.entities;
import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Converts a DatabaseEnum to/from a given type.
 *
 * @param <E> The enum class
 * @param <T> The database type to store
 */
public abstract class DatabaseEnumConverter<E extends DatabaseEnum<T>, T> implements AttributeConverter<DatabaseEnum<T>, T> {
    private final Map<T, DatabaseEnum<T>> values;

    public DatabaseEnumConverter(Class<E> type) {
        values = Arrays.stream(type.getEnumConstants()).collect(Collectors.toMap(DatabaseEnum::getValue, enu -> enu));
    }

    @Override
    public T convertToDatabaseColumn(DatabaseEnum<T> value) {
        return value == null ? null : value.getValue();
    }

    @Override
    public DatabaseEnum<T> convertToEntityAttribute(T value) {
        return value == null ? null : values.get(value);
    }
}
