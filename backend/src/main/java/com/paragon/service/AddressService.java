package com.paragon.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paragon.dto.AddressDTO;

/**
 *
 * @author Reddy
 *
 */
public interface AddressService {

	/**
	 * Get an address by Id
	 * @param id
	 * @return
	 */
    AddressDTO getAddress(Long id);
    /**
     * Update an existing address
     * @param addressDTO
     */
    void updateAddress(AddressDTO addressDTO);
    /**
     * Create a new address and associate with Person
     * @param addressDTO
     */
    void saveAddress(AddressDTO addressDTO);
    /**
     * Delete an address by Id
     * @param id
     */
    void deleteAddress(Long id);

    /**
     * Find an address by Id
     * @param pageable
     * @return
     */
	Page<AddressDTO> findAddresses(Pageable pageable);

}
