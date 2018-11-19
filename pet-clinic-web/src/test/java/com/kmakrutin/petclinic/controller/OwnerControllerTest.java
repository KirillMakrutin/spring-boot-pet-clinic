package com.kmakrutin.petclinic.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
}
