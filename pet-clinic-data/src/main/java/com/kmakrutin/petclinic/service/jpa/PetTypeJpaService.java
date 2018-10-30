package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.PetType;
import com.kmakrutin.petclinic.repository.PetTypeRepository;
import com.kmakrutin.petclinic.service.PetTypeService;

@Service
@Profile( "springdatajpa" )
public class PetTypeJpaService extends AbstractJpaService<PetType> implements PetTypeService
{
  private final PetTypeRepository petTypeRepository;

  public PetTypeJpaService( PetTypeRepository petTypeRepository )
  {
    super( petTypeRepository );
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public PetType findByName( String name )
  {
    return petTypeRepository.findByName( name );
  }
}
