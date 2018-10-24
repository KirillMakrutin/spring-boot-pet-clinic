package com.kmakrutin.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.model.Pet;
import com.kmakrutin.petclinic.model.Specialty;
import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.PetTypeService;
import com.kmakrutin.petclinic.service.SpecialityService;
import com.kmakrutin.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader( OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run( String... args )
    {
      if ( specialityService.findAll().isEmpty() )
      {
        addSpecialties();
        addOwners();
        addVets();
      }
    }

  private void addSpecialties()
  {
    Specialty radiology = new Specialty();
    radiology.setDescription( "radiology" );

    Specialty surgery = new Specialty();
    surgery.setDescription( "surgery" );

    Specialty dentist = new Specialty();
    dentist.setDescription( "dentist" );

    specialityService.save( radiology );
    specialityService.save( surgery );
    specialityService.save( dentist );

    System.out.println("Loaded specialties");
  }

  private void addVets() {
        Vet vetTom = new Vet();
        vetTom.setFirstName("Bob");
        vetTom.setLastName("Hardy");
        vetTom.getSpecialties().add( specialityService.findByDescription( "radiology" ) );
        vetTom.getSpecialties().add( specialityService.findByDescription( "therapist" ) );
        vetService.save(vetTom);

        Vet vetCarl = new Vet();
        vetCarl.setFirstName("Clara");
        vetCarl.setLastName("Pup");
        vetCarl.getSpecialties().add( specialityService.findByDescription( "surgery" ) );
        vetCarl.getSpecialties().add( specialityService.findByDescription( "dentist" ) );
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
