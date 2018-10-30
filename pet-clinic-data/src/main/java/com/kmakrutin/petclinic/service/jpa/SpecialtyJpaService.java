package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Specialty;
import com.kmakrutin.petclinic.repository.SpecialtyRepository;
import com.kmakrutin.petclinic.service.SpecialityService;

@Service
@Profile( "springdatajpa" )
public class SpecialtyJpaService extends AbstractJpaService<Specialty> implements SpecialityService
{
  private final SpecialtyRepository specialtyRepository;

  public SpecialtyJpaService( SpecialtyRepository specialtyRepository )
  {
    super( specialtyRepository );
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Specialty findByDescription( String description )
  {
    return specialtyRepository.findByDescription( description );
  }
}
