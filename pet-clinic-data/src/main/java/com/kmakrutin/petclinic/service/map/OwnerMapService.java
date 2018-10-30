package com.kmakrutin.petclinic.service.map;

import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.PetService;
import com.kmakrutin.petclinic.service.PetTypeService;

@Service
@Profile( { "default", "map" } )
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return findAll()
                .stream()
                .filter(owner -> lastName.equals(owner.getLastName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner entity) {
        Owner saved = super.save(entity);

        if (saved == null) {
            return null;
        }

        saved.setPets(saved.getPets().stream().map(pet -> {
            Pet savedPet = petService.save(pet);
            if (savedPet != null) {
                savedPet.setPetType(petTypeService.save(pet.getPetType()));
            }
            return savedPet;
        }).collect(Collectors.toSet()));

        return saved;
    }
}
