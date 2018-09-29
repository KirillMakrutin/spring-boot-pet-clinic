package com.kmakrutin.petclinic.bootstrap;

import com.kmakrutin.petclinic.model.PetType;
import com.kmakrutin.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner
{
  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;

  @Autowired
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
  {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

  @Override
  public void run( String... args )
  {
    addOwners();
    addVets();
    addPetTypes();
  }

  private void addPetTypes() {
    PetType dog = new PetType();
    dog.setName("Dog");

    PetType cat = new PetType();
    cat.setName("Cat");

    PetType mouse = new PetType();
    mouse.setName("Mouse");

    petTypeService.save(dog);
    petTypeService.save(cat);
    petTypeService.save(mouse);

    System.out.println( "Loaded pet types" );
  }

  private void addVets() {
    Vet vetTom = new Vet();
    vetTom.setFirstName( "Bob" );
    vetTom.setLastName( "Hardy" );
    vetService.save( vetTom );

    Vet vetCarl = new Vet();
    vetCarl.setFirstName( "Clara" );
    vetCarl.setLastName( "Pup" );
    vetService.save( vetCarl );

    System.out.println( "Loaded vets" );
  }

  private void addOwners() {
    Owner ownerTom = new Owner();
    ownerTom.setFirstName( "Tom" );
    ownerTom.setLastName( "Broddy" );
    ownerService.save( ownerTom );

    Owner ownerCarl = new Owner();
    ownerCarl.setFirstName( "Carl" );
    ownerCarl.setLastName( "Snow" );
    ownerService.save( ownerCarl );

    System.out.println( "Loaded owners" );
  }
}
