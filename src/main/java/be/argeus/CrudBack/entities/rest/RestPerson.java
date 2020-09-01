package be.argeus.CrudBack.entities.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class RestPerson extends AbstractRest {
    private String name;
    private String lastName;
    @Schema(implementation = Boolean.class)
    private String minor;
    @Schema(implementation = Boolean.class)
    private String resident;
    private String email;
    private String nationalNumber;
    private RestAddress address;
    private String birthPlace;
    private String dateOfBirth;
    @Schema(allowableValues = {"UNMARRIED", "MARRIED", "WIDOWED", "DIVORCED", "COHABITANT"})
    private String maritalStatus;
    private String partnerName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public RestAddress getAddress() {
        return address;
    }

    public void setAddress(RestAddress address) {
        this.address = address;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getEmail() { return email;  }

    public void setEmail(String email) { this.email = email; }
}
