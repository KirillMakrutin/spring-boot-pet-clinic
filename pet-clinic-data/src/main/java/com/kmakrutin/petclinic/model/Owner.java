package com.kmakrutin.petclinic.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true, exclude = { "pets" } )
@Entity
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Transient
    public String getPetNames() {
        return pets.stream()
                .map(pet -> pet.getName() + (pet.getPetType() != null ? " is a " + pet.getPetType().getName() : ""))
                .collect(Collectors.joining(", "));
    }
}
