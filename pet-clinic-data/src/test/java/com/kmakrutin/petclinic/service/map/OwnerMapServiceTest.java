package com.kmakrutin.petclinic.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.PetService;
import com.kmakrutin.petclinic.service.PetTypeService;

class OwnerMapServiceTest
{
  @Mock
  private PetService petService;
  @Mock
  private PetTypeService petTypeService;

  private OwnerService ownerService;

  @BeforeEach
  void setUp()
  {
    MockitoAnnotations.initMocks( this );

    ownerService = new OwnerMapService( petTypeService, petService );
  }

  @Test
  void findByLastName()
  {
    saveNewOwner();
    assertNotNull( ownerService.findByLastName( "Last name" ) );
  }

  @Test
  void save()
  {
    Owner saved = ownerService.save( createOwner() );
    assertNotNull( saved );
    assertEquals( new Long( 1 ), saved.getId() );
  }

  @Test
  void update()
  {
    saveNewOwner();
    Owner ownerToUpdate = ownerService.findById( 1L );
    ownerToUpdate.setFirstName( "New first name" );
    ownerService.save( ownerToUpdate );
    Owner ownerUpdated = ownerService.findById( 1L );
    assertEquals( "New first name", ownerUpdated.getFirstName() );
  }


  @Test
  void findById()
  {
    saveNewOwner();
    assertNotNull( ownerService.findById( 1L ) );
  }

  @Test
  void findAll()
  {
    saveNewOwner();
    assertEquals( 1, ownerService.findAll().size() );
  }

  @Test
  void delete()
  {
    saveNewOwner();
    assertNotNull( ownerService.findById( 1L ) );
    Owner ownerToDelete = new Owner();
    ownerToDelete.setId( 1L );
    ownerService.delete( ownerToDelete );
    assertNull( ownerService.findById( 1L ) );
  }

  @Test
  void deleteById()
  {
    saveNewOwner();
    assertNotNull( ownerService.findById( 1L ) );
    ownerService.deleteById( 1L );
    assertNull( ownerService.findById( 1L ) );
  }

  private Owner createOwner()
  {
    Owner owner = new Owner();
    owner.setFirstName( "First name" );
    owner.setLastName( "Last name" );
    owner.setTelephone( "111-111-1111" );
    owner.setAddress( "Test Address" );
    owner.setCity( "Test City" );

    return owner;
  }

  private void saveNewOwner()
  {
    ownerService.save( createOwner() );
  }
}
