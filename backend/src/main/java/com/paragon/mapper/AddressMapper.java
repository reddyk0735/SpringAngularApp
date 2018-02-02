package com.paragon.mapper;

import com.paragon.dto.AddressDTO;
import com.paragon.models.Address;

public interface AddressMapper {

    public AddressDTO toDTO(Address address);
    public Address toEntity(AddressDTO addressDTO);
}
