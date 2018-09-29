package com.kmakrutin.petclinic.bootstrap;

import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.model.PetType;
import com.kmakrutin.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        addOwners();
        addVets();
    }

    private void addVets() {
        Vet vetTom = new Vet();
        vetTom.setFirstName("Bob");
        vetTom.setLastName("Hardy");
        vetService.save(vetTom);

        Vet vetCarl = new Vet();
        vetCarl.setFirstName("Clara");
        vetCarl.setLastName("Pup");
        vetService.save(vetCarl);

        System.out.println("Loaded vets");
    }

    private void addOwners() {
        Owner ownerTom = new Owner();
        ownerTom.setFirstName("Tom");
        ownerTom.setLastName("Broddy");
        ownerTom.setCity("Minsk");
        ownerTom.setAddress("Nezavisimosty 12");
        ownerTom.setTelephone("555-555-5555");
        Pet tomPetDogGuf = new Pet();
        tomPetDogGuf.setPetType(petTypeService.findByName("Dog"));
        tomPetDogGuf.setBirthDate(LocalDate.of(2013, 9, 15));
        tomPetDogGuf.setName("Guf");

        Pet tomPetDogFreddy = new Pet();
        tomPetDogFreddy.setPetType(petTypeService.findByName("Dog"));
        tomPetDogFreddy.setBirthDate(LocalDate.of(2013, 7, 20));
        tomPetDogFreddy.setName("Freddy");

        ownerTom.getPets().add(tomPetDogGuf);
        ownerTom.getPets().add(tomPetDogFreddy);
        ownerService.save(ownerTom);

        Owner ownerCarl = new Owner();
        ownerCarl.setFirstName("Carl");
        ownerCarl.setLastName("Snow");
        ownerCarl.setCity("Moscow");
        ownerCarl.setAddress("Krsnaja 12");
        ownerCarl.setTelephone("111-555-1234");
        Pet carlPet = new Pet();
        carlPet.setPetType(petTypeService.findByName("Cat"));
        carlPet.setName("Mew");
        carlPet.setBirthDate(LocalDate.of(2010, 1, 13));
        ownerCarl.getPets().add(carlPet);
        ownerService.save(ownerCarl);

        System.out.println("Loaded owners");
    }
}
