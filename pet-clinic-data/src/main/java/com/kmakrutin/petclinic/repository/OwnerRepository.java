package com.kmakrutin.petclinic.repository;

import com.kmakrutin.petclinic.model.Owner;

public interface OwnerRepository extends WrappedCrudRepository<Owner, Long>
{
  Owner findByLastName(String lastName);
}
