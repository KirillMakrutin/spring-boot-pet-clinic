package com.kmakrutin.petclinic.service.map;

import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.service.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService
{
}
