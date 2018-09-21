package com.kmakrutin.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.service.VetService;

@Controller
public class VetController
{
  private final VetService vetService;

  @Autowired
  public VetController( VetService vetService )
  {
    this.vetService = vetService;
  }

  @GetMapping( { "/vets", "/vets/index", "/vets/index.html" } )
  public String listVets( Model model )
  {
    Vet vetTom = new Vet();
    vetTom.setFirstName( "Tom" );
    vetTom.setLastName( "Broddy" );

    Vet vetCarl = new Vet();
    vetCarl.setFirstName( "Carl" );
    vetCarl.setLastName( "Snow" );
    model.addAttribute( "vets", vetService.findAll() );

    return "vets/index";
  }
}
