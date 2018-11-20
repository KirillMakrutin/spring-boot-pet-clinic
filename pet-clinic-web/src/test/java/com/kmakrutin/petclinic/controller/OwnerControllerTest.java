package com.kmakrutin.petclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.service.OwnerService;

@ExtendWith( MockitoExtension.class )
class OwnerControllerTest
{
  @Mock
  private OwnerService ownerService;

  @InjectMocks
  private OwnerController controller;

  private MockMvc mockMvc;
  private Set<Owner> owners;

  @BeforeEach
  void setUp()
  {
    owners = new HashSet<>();
    Owner owner = new Owner();
    owner.setId( 1L );
    owner.setFirstName( "First name" );
    owner.setLastName( "Last name" );
    owner.setTelephone( "111-111-1111" );
    owner.setAddress( "Test Address" );
    owner.setCity( "Test City" );
    owners.add( owner );

    mockMvc = MockMvcBuilders.standaloneSetup( controller ).build();
  }

  @Test
  void list() throws Exception
  {
    when( ownerService.findAll() ).thenReturn( owners );

    mockMvc.perform( get( "/owners" ) )
        .andExpect( status().isOk() )
        .andExpect( view().name( "owners/index" ) )
        .andExpect( model().attribute( "owners", hasSize( 1 ) ) );
  }

  @Test
  void showOwner() throws Exception
  {
    Owner owner = new Owner();
    when( ownerService.findById( anyLong() ) ).thenReturn( owner );

    mockMvc.perform( get( "/owners/2" ) )
        .andExpect( status().isOk() )
        .andExpect( view().name( "owners/ownerDetails" ) )
        .andExpect( model().attribute( "owner", owner ) );
  }

  @Test
  void processFindFormNone() throws Exception
  {
    when( ownerService.findByLastNameLike( anyString() ) ).thenReturn( Collections.emptyList() );

    mockMvc.perform( get( "/owners" ) )
        .andExpect( status().isOk() )
        .andExpect( view().name( "owners/findOwners" ) )
        .andExpect( model().attribute( "owners", is( nullValue() ) ) );
  }

  @Test
  void processFindFormSingle() throws Exception
  {
    Owner owner = new Owner();
    owner.setId( 2L );
    when( ownerService.findByLastNameLike( anyString() ) ).thenReturn( Collections.singletonList( owner ) );

    mockMvc.perform( get( "/owners" ) )
        .andExpect( status().is3xxRedirection() )
        .andExpect( view().name( "redirect:/owners/2" ) );
  }

  @Test
  void processFindFormMany() throws Exception
  {
    when( ownerService.findByLastNameLike( anyString() ) ).thenReturn( Arrays.asList( new Owner(), new Owner() ) );

    mockMvc.perform( get( "/owners" ) )
        .andExpect( status().isOk() )
        .andExpect( view().name( "owners/index" ) )
        .andExpect( model().attribute( "owners", hasSize( 2 ) ) );
  }

  @Test
  void initFindForm() throws Exception
  {
    mockMvc.perform( get( "/owners/find" ) )
        .andExpect( status().isOk() )
        .andExpect( view().name( "owners/findOwners" ) )
        .andExpect( model().attribute( "owner", is( notNullValue() ) ) );
  }
}
