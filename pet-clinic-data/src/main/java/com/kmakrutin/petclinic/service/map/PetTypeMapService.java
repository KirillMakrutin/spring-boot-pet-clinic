package com.kmakrutin.petclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.PetType;
import com.kmakrutin.petclinic.service.PetTypeService;

@Service
@Profile( { "default", "map" } )
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {
    @Override
    public PetType findByName(String name) {
        return findAll()
                .stream()
                .filter(petType -> name.equalsIgnoreCase(petType.getName())).findFirst().orElseGet(() -> {
                    PetType petType = new PetType();
                    petType.setName(name);

                    return save(petType);
                });
    }
}
