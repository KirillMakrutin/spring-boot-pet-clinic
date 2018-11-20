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
    PetType byName = petTypeRepository.findByName( name );

    if ( byName == null )
    {
      byName = new PetType();
      byName.setName( name );
      byName = save( byName );
    }

    return byName;
  }
}
