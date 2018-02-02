package com.paragon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paragon.dto.PersonDTO;
import com.paragon.service.PersonService;

/**
 *
 * @author Reddy
 * Hello Controller , Which handles all CRUD operations on Person
 */

@RestController
@CrossOrigin
@RequestMapping(value = "person")
public class HelloController {

	@Autowired
	PersonService personService;


	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String indexPost(@RequestBody Object obj) {
		return "Greetings from Spring Boot Post!";
	}



	/**
	 * Find all persons
	 * @param pageable
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PersonDTO>> findAllPersons(Pageable pageable, HttpServletRequest req) {
		Page<PersonDTO> page = personService.findPersons(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	/**
	 * Find a person by ID
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id, HttpServletRequest req) {
		PersonDTO person = personService.getPerson(id);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	/**
	 * Create a new person
	 * @param personDTO
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPerson(@RequestBody PersonDTO personDTO) {
		personService.savePerson(personDTO);
		return "{\"status\":\"success\"}";
	}

	/**
	 * Update a person
	 * @param id
	 * @param personDTO
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updatePerson(@PathVariable Long id,@RequestBody PersonDTO personDTO) {
		personDTO.setId(id);
		personService.updatePerson(personDTO);
		return "{\"status\":\"success\"}";
	}

	/**
	 * Delete a person and its assosiated addresses
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePerson(@PathVariable String id) {
		personService.deletePerson(Long.valueOf(id));
		return "{\"status\":\"success\"}";
	}
}
