package com.kmakrutin.petclinic.repository;

import com.kmakrutin.petclinic.model.Pet;

public interface PetRepository extends WrappedCrudRepository<Pet, Long>
{
}
