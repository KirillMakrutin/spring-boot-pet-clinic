package com.kmakrutin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.kmakrutin.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>
{
}
