package com.kmakrutin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.kmakrutin.petclinic.model.PetType;

/**
 * Created on 29/10/2018.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long>
{
}
