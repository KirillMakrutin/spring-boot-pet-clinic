package com.kmakrutin.petclinic.repository;

import java.util.List;

import com.kmakrutin.petclinic.model.Owner;

public interface OwnerRepository extends WrappedCrudRepository<Owner, Long>
{
  Owner findByLastName(String lastName);

  List<Owner> findByLastNameIgnoreCaseContaining(String lastName);
}
