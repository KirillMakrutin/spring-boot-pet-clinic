package com.kmakrutin.petclinic.service;


import java.util.Set;

import com.kmakrutin.petclinic.model.Owner;

public interface OwnerService
{
  Owner findByLastName( String lastName );

  Owner findById( Long id );

  Owner save( Owner owner );

  Set<Owner> findAll();
}
