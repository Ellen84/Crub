package be.argeus.CrudBack.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "persons")
public class PersonEntity {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    private boolean minor;
    private boolean resident;
    @NotNull
    private String email;
    @NotNull
    private String nationalNumber;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AddressEntity address;
    private String birthPlace;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    private String partnerName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public boolean isMinor() {
        return minor;
    }

    public void setMinor(boolean minor) {
        this.minor = minor;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonEntity that = (PersonEntity) o;
        return minor == that.minor &&
                resident == that.resident &&
                name.equals(that.name) &&
                lastName.equals(that.lastName) &&
                nationalNumber.equals(that.nationalNumber) &&
                address.equals(that.address) &&
                birthPlace.equals(that.birthPlace) &&
                dateOfBirth.equals(that.dateOfBirth) &&
                maritalStatus.equals(that.maritalStatus) &&
                partnerName.equals(that.partnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                name,
                lastName,
                minor,
                resident,
                nationalNumber,
                address,
                birthPlace,
                dateOfBirth,
                maritalStatus,
                partnerName);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
