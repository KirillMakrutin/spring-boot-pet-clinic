package com.kmakrutin.petclinic.service.map;

import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.service.OwnerService;

@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService
{
  @Override
  public Owner findByLastName( String lastName )
  {
    return findAll()
        .stream()
        .filter( owner -> lastName.equals( owner.getLastName() ) )
        .findFirst()
        .orElse( null );
  }
}
