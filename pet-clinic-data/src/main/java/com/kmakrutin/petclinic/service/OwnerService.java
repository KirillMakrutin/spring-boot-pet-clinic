package com.kmakrutin.petclinic.service;


import java.util.List;

import com.kmakrutin.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
  Owner findByLastName( String lastName );

  List<Owner> findByLastNameLike( String lastName );
}
