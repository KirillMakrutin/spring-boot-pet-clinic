package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.repository.VetRepository;
import com.kmakrutin.petclinic.service.VetService;

@Service
@Profile( "springdatajpa" )
public class VetJpaService extends AbstractJpaService<Vet> implements VetService
{
  VetJpaService( VetRepository vetRepository )
  {
    super( vetRepository );
  }
}
