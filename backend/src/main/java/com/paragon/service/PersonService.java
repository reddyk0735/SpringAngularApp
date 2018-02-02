package com.paragon.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paragon.dto.PersonDTO;

public interface PersonService {

	/**
	 * Find all persons
	 * @param pageable
	 * @return
	 */
    Page<PersonDTO> findPersons(Pageable pageable);

    /**
     * Find person by id
     * @param id
     * @return
     */
    PersonDTO getPerson(Long id);

    /**
     * Update a person
     * @param personDTO
     */
    void updatePerson(PersonDTO personDTO);

    /**
     * Save a Person
     * @param personDTO
     */
    void savePerson(PersonDTO personDTO);

    /**
     * Delete a Person by id
     * @param id
     */
    void deletePerson(Long id);

}
