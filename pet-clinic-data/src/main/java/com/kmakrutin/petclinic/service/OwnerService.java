package com.kmakrutin.petclinic.service;


import com.kmakrutin.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
  Owner findByLastName( String lastName );
}
