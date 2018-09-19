package com.kmakrutin.petclinic.service;

import java.util.Set;

import com.kmakrutin.petclinic.model.Pet;

public interface PetService
{
  Pet findById( Long id );

  Pet save( Pet pet );

  Set<Pet> findAll();
}
