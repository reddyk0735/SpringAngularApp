package com.paragon.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paragon.dto.AddressDTO;
import com.paragon.dto.PersonDTO;
import com.paragon.mapper.PersonMapper;
import com.paragon.models.Address;
import com.paragon.models.Person;
import com.paragon.repos.AddressRepository;
import com.paragon.repos.PersonRepository;


/**
 * Service layer on Person
 * @author Reddy
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    final static Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    AddressRepository addressRepository;

    /**
     * Mapper converts DTO to entity and Entity to DTO
     */
    PersonMapper personMapper = new PersonMapper() {

		@Override
		public Person toEntity(PersonDTO person) {
			Person personEntity = new Person();
			personEntity.setFirstName(person.getFirstName());
			personEntity.setLastName(person.getLastName());
			personEntity.setDob(person.getDob());
			personEntity.setAge(person.getAge());
			personEntity.setId(person.getId());
			personEntity.setMiddleName(person.getMiddleName());
			personEntity.setOccupation(person.getOccupation());
			return personEntity;
		}

		/**
		 * Convert Entity to DTO
		 */
		@Override
		public PersonDTO toDTO(Person person) {
			PersonDTO personDto = new PersonDTO();
			personDto.setFirstName(person.getFirstName());
			personDto.setLastName(person.getLastName());
			personDto.setDob(person.getDob());
			personDto.setAge(person.getAge());
			personDto.setId(person.getId());
			personDto.setMiddleName(person.getMiddleName());
			personDto.setOccupation(person.getOccupation());
			List<Address> addressDTOs = person.getAddresses();
			List<AddressDTO> dtos = new ArrayList<>();
			for (Address address : addressDTOs) {
				AddressDTO dto = new AddressDTO();
				dto.setAddress1(address.getAddress1());
				dto.setAddress2(address.getAddress2());
				dto.setCity(address.getCity());
				dto.setId(address.getId());
				dto.setState(address.getState());
				dto.setZipCode(address.getZipCode());
				dtos.add(dto);
			}
			personDto.setAddresses(dtos);
			return personDto;
		}
	};

    @Override
    public Page<PersonDTO> findPersons(Pageable pageable) {
        return personRepository.findAll(pageable).map(person -> personMapper.toDTO(person));
    }

    @Override
    public PersonDTO getPerson(Long id) {
        Person person = personRepository.findOne(id);
        if (person == null) {
            return null;
        } else {
            return personMapper.toDTO(person);
        }
    }


    @Override
    public void updatePerson(PersonDTO personDTO) {
        Person person = personRepository.findOne(personDTO.getId());
        if(person == null)
        	return;
        person = personMapper.toEntity(personDTO);
        person.setUpdatedOn(new Timestamp(new Date().getTime()));
        personRepository.save(person);
    }

    @Override
    public void savePerson(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        person.setCreatedOn(new Timestamp(new Date().getTime()));
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id);

    }
}
