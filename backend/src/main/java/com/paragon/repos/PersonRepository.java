package com.paragon.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paragon.models.Person;

@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

 
}