package com.kmakrutin.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

  @GetMapping( { "", "/", "/index", "/index.html" } )
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
}
