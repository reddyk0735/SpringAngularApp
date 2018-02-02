package com.paragon.service;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paragon.dto.AddressDTO;
import com.paragon.mapper.AddressMapper;
import com.paragon.models.Address;
import com.paragon.models.Person;
import com.paragon.repos.AddressRepository;
import com.paragon.repos.PersonRepository;



@Service
@Transactional
public class AddressServiceImpl implements AddressService{

    final static Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    AddressRepository addressRepository;
    
    @Autowired
    PersonRepository personRepository;

    AddressMapper addressMapper = new AddressMapper() {
		
		@Override
		public Address toEntity(AddressDTO addressDTO) {
			Address address = new Address();
			address.setAddress1(addressDTO.getAddress1());
			address.setAddress2(addressDTO.getAddress2());
			address.setCity(addressDTO.getCity());
			address.setId(addressDTO.getId());
			address.setState(addressDTO.getState());
			address.setZipCode(addressDTO.getZipCode());
			Person person = personRepository.findOne(addressDTO.getPersonId());
			address.setPerson(person);
			return address;
		}
		
		@Override
		public AddressDTO toDTO(Address address) {
			AddressDTO addressDto = new AddressDTO();
			addressDto.setAddress1(address.getAddress1());
			addressDto.setAddress2(address.getAddress2());
			addressDto.setCity(address.getCity());
			addressDto.setId(address.getId());
			addressDto.setState(address.getState());
			addressDto.setZipCode(address.getZipCode());
			return addressDto;
		}
	};
	
	 @Override
	    public Page<AddressDTO> findAddresses(Pageable pageable) {
	        return addressRepository.findAll(pageable).map(address -> addressMapper.toDTO(address));
	    }

	@Override
    public AddressDTO getAddress(Long id) {
        Address address = addressRepository.findOne(id);
        if (address == null) {
            return null;
        } else {
            return addressMapper.toDTO(address);
        }
    }

    @Override
    public void saveAddress(AddressDTO personDTO) {
        Address address = addressMapper.toEntity(personDTO);
        address.setCreatedOn(new Timestamp(new Date().getTime()));
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.delete(id);
    }

	@Override
	public void updateAddress(AddressDTO addressDTO) {
		 Address address = addressRepository.findOne(addressDTO.getId());
	        if(address == null)
	        	return;
	        address = addressMapper.toEntity(addressDTO);
	        address.setUpdatedOn(new Timestamp(new Date().getTime()));
	        addressRepository.save(address);
	}
}
