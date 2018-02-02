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

import com.paragon.dto.AddressDTO;
import com.paragon.service.AddressService;

/**
 *
 * @author Reddy
 * Address Controller , Which handles all CRUD operations on Address
 */
@RestController
@CrossOrigin
@RequestMapping(value = "address")
public class AddressController {

	@Autowired
	AddressService addressService;

	/**
	 * Find all addresses
	 * @param pageable
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<AddressDTO>> findAllAddress(Pageable pageable, HttpServletRequest req) {
		Page<AddressDTO> page = addressService.findAddresses(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	/**
	 * Get an existing address by its id
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressDTO> getAddress(@PathVariable Long id, HttpServletRequest req) {
		AddressDTO address = addressService.getAddress(id);
		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	/**
	 * Create a new address and associate it to person
	 * @param addressDTO
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createAddress(@RequestBody AddressDTO addressDTO) {
		System.out.println("Address create " + addressDTO.toString());
		addressService.saveAddress(addressDTO);
		return "{\"status\":\"success\"}";
	}

	/**
	 * Update an existing address
	 * @param addressDTO
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateAddress(@PathVariable String id,@RequestBody AddressDTO addressDTO) {
		addressDTO.setId(Long.valueOf(id));
		addressService.updateAddress(addressDTO);
		return "{\"status\":\"success\"}";
	}

	/**
	 * Delete an addres
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteAddress(@PathVariable String id) {
		addressService.deleteAddress(Long.valueOf(id));
		return "{\"status\":\"success\"}";
	}
}
