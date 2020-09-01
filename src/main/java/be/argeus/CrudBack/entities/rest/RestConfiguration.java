package be.argeus.CrudBack.entities.rest;

import be.argeus.CrudBack.exceptions.SystemException;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
public class RestConfiguration {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addConverter(new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                try {
                    return StringUtils.isEmpty(source) ? null : LocalDate.parse(source, DATE_FORMAT);
                } catch (DateTimeParseException e) {
                    throw new SystemException("Error parsing date: " + source);
                }
            }
        }, String.class, LocalDate.class);
        modelMapper.addConverter(new AbstractConverter<LocalDate, String>() {
            @Override
            protected String convert(LocalDate source) {
                return source == null ? null : source.atStartOfDay().format(DATE_FORMAT);
            }
        }, LocalDate.class, String.class);
        return modelMapper;
    }
}
