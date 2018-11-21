package com.kmakrutin.petclinic.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmakrutin.petclinic.model.Owner;
import com.kmakrutin.petclinic.service.OwnerService;

@Controller
@RequestMapping( "/owners" )
public class OwnerController
{
  private final OwnerService ownerService;

  @Autowired
  public OwnerController( OwnerService ownerService )
  {
    this.ownerService = ownerService;
  }

  @GetMapping( "/find" )
  public String initFindForm( Model model )
  {
    model.addAttribute( "owner", new Owner() );
    return "owners/findOwners";
  }

  @GetMapping( "" )
  public String processFindForm( Owner owner, BindingResult result, Model model )
  {
    // allow parameterless GET request for /owners to return all records
    if ( owner.getLastName() == null )
    {
      owner.setLastName( "" ); // empty string signifies broadest possible search
    }

    // find owners by last name
    Collection<Owner> results = ownerService.findByLastNameLike( owner.getLastName() );
    if ( results.isEmpty() )
    {
      // no owners found
      result.rejectValue( "lastName", "notFound", "not found" );

      return "owners/findOwners";
    }
    else if ( results.size() == 1 )
    {
      // 1 owner found
      owner = results.iterator().next();
      return "redirect:/owners/" + owner.getId();
    }
    else
    {
      // multiple owners found
      model.addAttribute( "owners", results );

      return "owners/index";
    }
  }

  @GetMapping( { "list", "/index", "/index.html" } )
  public String list( Model model )
  {
    model.addAttribute( "owners", ownerService.findAll() );

    return "owners/index";
  }

  @GetMapping( "/{ownerId}" )
  public String showOwner( @PathVariable long ownerId, Model model )
  {
    model.addAttribute( "owner", ownerService.findById( ownerId ) );

    return "owners/ownerDetails";
  }

  @GetMapping( "/new" )
  public String newOwner( Model model )
  {
    Owner newOwner = new Owner();
    newOwner.setNew( true );
    model.addAttribute( "owner", newOwner );

    return "owners/createOrUpdateOwnerForm";
  }

  @GetMapping( "/{ownerId}/edit" )
  public String editOwner( @PathVariable long ownerId, Model model )
  {
    model.addAttribute( "owner", ownerService.findById( ownerId ) );

    return "owners/createOrUpdateOwnerForm";
  }

  @PostMapping
  public String saveOrUpdateOwner( @Valid Owner owner, BindingResult result )
  {
    if ( result.hasErrors() )
    {
      return "owners/createOrUpdateOwnerForm";
    }

    Owner saved = ownerService.save( owner );
    return "redirect:/owners/" + saved.getId();
  }
}
