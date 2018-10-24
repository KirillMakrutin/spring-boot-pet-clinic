package com.kmakrutin.petclinic.service;

import com.kmakrutin.petclinic.model.Specialty;

public interface SpecialityService extends CrudService<Specialty, Long> {
  Specialty findByDescription( String description );
}
