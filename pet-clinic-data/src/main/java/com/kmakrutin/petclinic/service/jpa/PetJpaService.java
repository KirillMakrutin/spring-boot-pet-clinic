package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.repository.PetRepository;
import com.kmakrutin.petclinic.service.PetService;

@Service
@Profile( "springdatajpa" )
public class PetJpaService extends AbstractJpaService<Pet> implements PetService
{
  public PetJpaService( PetRepository petRepository )
  {
    super( petRepository );
  }
}
