package com.kmakrutin.petclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.service.PetService;

@Service
@Profile( { "default", "map" } )
public class PetMapService extends AbstractMapService<Pet> implements PetService
{
}
