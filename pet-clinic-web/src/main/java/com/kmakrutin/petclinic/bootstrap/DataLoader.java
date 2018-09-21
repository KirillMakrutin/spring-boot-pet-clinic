package com.kmakrutin.petclinic.bootstrap;

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

  @Autowired
  public DataLoader( OwnerService ownerService, VetService vetService )
  {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run( String... args )
  {
    Owner ownerTom = new Owner();
    ownerTom.setFirstName( "Tom" );
    ownerTom.setLastName( "Broddy" );
    ownerService.save( ownerTom );

    Owner ownerCarl = new Owner();
    ownerCarl.setFirstName( "Carl" );
    ownerCarl.setLastName( "Snow" );
    ownerService.save( ownerCarl );

    System.out.println( "Loaded owners" );

    Vet vetTom = new Vet();
    vetTom.setFirstName( "Tom" );
    vetTom.setLastName( "Hardy" );
    vetService.save( vetTom );

    Vet vetCarl = new Vet();
    vetCarl.setFirstName( "Carl" );
    vetCarl.setLastName( "Pup" );
    vetService.save( vetCarl );

    System.out.println( "Loaded vets" );
  }
}
