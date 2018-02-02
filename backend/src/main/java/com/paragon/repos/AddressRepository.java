package com.paragon.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paragon.models.Address;

/**
 * Repository layer on Address
 * @author Reddy
 *
 */
@RepositoryRestResource
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {


}
