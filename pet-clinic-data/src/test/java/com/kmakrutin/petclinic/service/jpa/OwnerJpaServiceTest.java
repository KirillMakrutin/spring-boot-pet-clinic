package com.kmakrutin.petclinic.service.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.repository.OwnerRepository;
import com.kmakrutin.petclinic.service.OwnerService;

@ExtendWith( MockitoExtension.class )
class OwnerJpaServiceTest
{
  @Mock
  private OwnerRepository ownerRepository;

  private OwnerService ownerService;

  @BeforeEach
  void setUp()
  {
    ownerService = new OwnerJpaService( ownerRepository );
  }

  @Test
  void findByLastName()
  {
    when( ownerRepository.findByLastName( anyString() ) ).thenReturn( owner() );
    assertNotNull( ownerService.findByLastName( "Last name" ) );
    verify( ownerRepository, times( 1 ) ).findByLastName( anyString() );
  }

  @Test
  void findById()
  {
    when( ownerRepository.findById( anyLong() ) ).thenReturn( Optional.of( owner() ) );
    assertNotNull( ownerService.findById( 1L ) );
    verify( ownerRepository, times( 1 ) ).findById( anyLong() );
  }

  @Test
  void save()
  {
    when( ownerRepository.save( any( Owner.class ) ) ).thenReturn( owner() );
    assertNotNull( ownerService.save( new Owner() ) );
    verify( ownerRepository, times( 1 ) ).save( any( Owner.class ) );
  }

  @Test
  void findAll()
  {
    when( ownerRepository.findAll() ).thenReturn( Collections.singleton( owner() ) );
    assertEquals( 1, ownerService.findAll().size() );
    verify( ownerRepository, times( 1 ) ).findAll();
  }

  @Test
  void delete()
  {
    ownerService.delete( new Owner() );
    verify( ownerRepository, times( 1 ) ).delete( any( Owner.class ) );
  }

  @Test
  void deleteById()
  {
    ownerService.deleteById( 1L );
    verify( ownerRepository, times( 1 ) ).deleteById( anyLong() );
  }

  private Owner owner()
  {
    Owner owner = new Owner();
    owner.setId( 1L );
    owner.setFirstName( "First name" );
    owner.setLastName( "Last name" );
    owner.setTelephone( "111-111-1111" );
    owner.setAddress( "Test Address" );
    owner.setCity( "Test City" );

    return owner;
  }
}
