package com.kmakrutin.petclinic.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.model.PetType;
import com.kmakrutin.petclinic.service.OwnerService;
import com.kmakrutin.petclinic.service.PetTypeService;
import com.kmakrutin.petclinic.validator.PetValidator;

@Controller
@RequestMapping( "/owner/{ownerId}" )
public class PetController
{
  private final PetTypeService petTypes;
  private final OwnerService owners;

  public PetController( PetTypeService petTypes, OwnerService owners )
  {
    this.petTypes = petTypes;
    this.owners = owners;
  }

  @ModelAttribute( "types" )
  public Collection<PetType> populatePetTypes()
  {
    return petTypes.findAll();
  }

  @ModelAttribute( "owner" )
  public Owner findOwner( @PathVariable( "ownerId" ) long ownerId )
  {
    return owners.findById( ownerId );
  }

  @InitBinder( "owner" )
  public void initOwnerBinder( WebDataBinder dataBinder )
  {
    dataBinder.setDisallowedFields( "id" );
  }

  @InitBinder( "pet" )
  public void initPetBinder( WebDataBinder dataBinder )
  {
    dataBinder.setValidator( new PetValidator() );
  }
}
