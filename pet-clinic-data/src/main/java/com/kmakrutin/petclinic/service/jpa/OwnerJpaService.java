package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.repository.OwnerRepository;
import com.kmakrutin.petclinic.service.OwnerService;

@Service
@Profile( "springdatajpa" )
public class OwnerJpaService extends AbstractJpaService<Owner> implements OwnerService
{
  private final OwnerRepository ownerRepository;

  public OwnerJpaService( OwnerRepository ownerRepository )
  {
    super( ownerRepository );
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Owner findByLastName( String lastName )
  {
    return ownerRepository.findByLastName( lastName );
  }
}
