package com.kmakrutin.petclinic.service.map;

import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Specialty;
import com.kmakrutin.petclinic.service.SpecialityService;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty> implements SpecialityService
{

  @Override
  public Specialty findByDescription( String description )
  {
    if ( description == null )
    {
      return null;
    }

    return findAll().stream()
        .filter( specialty -> description.equalsIgnoreCase( specialty.getDescription() ) )
        .findFirst()
        .orElseGet( () -> {
          Specialty specialty = new Specialty();
          specialty.setDescription( description );
          return save( specialty );
        } );
  }
}
