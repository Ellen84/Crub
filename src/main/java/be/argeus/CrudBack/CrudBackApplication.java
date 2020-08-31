package be.argeus.CrudBack;

import be.argeus.CrudBack.entities.AddressEntity;
import be.argeus.CrudBack.entities.MaritalStatus;
import be.argeus.CrudBack.entities.PersonEntity;
import be.argeus.CrudBack.repositories.PersonsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "be.argeus")
public class CrudBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudBackApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	PersonsRepository init(PersonsRepository personsRepository) {
		AddressEntity address = getAddressEntity("Lalastraat", "Beringen", "3580", "België");

		PersonEntity person = setPerson("Alika", "Dangote", false, true,
				"aliko.dangote@argeus.be", "89073116530", address, "Hasselt", LocalDate.of(1989,07,31),
				MaritalStatus.UNMARRIED, "Lara Bandala");

		personsRepository.save(person);

		address = getAddressEntity("GestelStraat", "Lummen", "3560", "België");
		person = setPerson("Bill", "Gates", false, true, "bill.gates@argeus.be",
				"65062016790", address, "New York",  LocalDate.of(1965, 06, 20),
				MaritalStatus.MARRIED, "Jane Tarzan");

		personsRepository.save(person);
		return personsRepository;
	}

	@NotNull
	private AddressEntity getAddressEntity(String street, String city, String postcode, String country) {
		AddressEntity address = new AddressEntity();
		address.setCity(city);
		address.setStreet(street);
		address.setPostcode(postcode);
		address.setCountry(country);
		return address;
	}

	private PersonEntity setPerson(String name, String lastName, Boolean minor, Boolean resident, String email, String nationalNumber, AddressEntity address, String birthPlace, LocalDate dateOfBirth, MaritalStatus maritalStatus, String partnerName) {
		PersonEntity person = new PersonEntity();
		person.setName(name);
		person.setLastName(lastName);
		person.setMinor(minor);
		person.setResident(resident);
		person.setEmail(email);
		person.setNationalNumber(nationalNumber);
		person.setAddress(address);
		person.setBirthPlace(birthPlace);
		person.setDateOfBirth(dateOfBirth);
		person.setMaritalStatus(maritalStatus);
		person.setPartnerName(partnerName);
		return person;
	}
}
