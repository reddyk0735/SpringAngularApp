package com.paragon.mapper;

import com.paragon.dto.PersonDTO;
import com.paragon.models.Person;

public interface PersonMapper {

    public PersonDTO toDTO(Person person);
    public Person toEntity(PersonDTO person);
}
