package be.argeus.CrudBack.entities;

import javax.persistence.Converter;

public enum MaritalStatus implements DatabaseEnum<String> {
    UNMARRIED("UNMARRIED"), MARRIED("MARRIED"), WIDOWED("WIDOWED"), DIVORCED("DIVORCED"), COHABITANT("COHABITANT");

    private final String key;

    MaritalStatus(String maritalStatus) {
        this.key = maritalStatus;
    }

    @Override
    public String getValue() {
        return key;
    }

    @Converter(autoApply = true)
    public static class JpaConverter extends DatabaseEnumConverter<MaritalStatus, String> {
        public JpaConverter() {
            super(MaritalStatus.class);
        }
    }
}
