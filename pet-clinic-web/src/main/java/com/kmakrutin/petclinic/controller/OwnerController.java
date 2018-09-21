package com.kmakrutin.petclinic.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmakrutin.petclinic.model.Owner;

@Controller
@RequestMapping( "/owners" )
public class OwnerController
{
  @GetMapping( { "", "/index", "/index.html" } )
  public String list( Model model )
  {
    Owner ownerTom = new Owner();
    ownerTom.setFirstName( "Tom" );
    ownerTom.setLastName( "Broddy" );

    Owner ownerCarl = new Owner();
    ownerCarl.setFirstName( "Carl" );
    ownerCarl.setLastName( "Snow" );
    model.addAttribute( "owners", Arrays.asList( ownerTom, ownerCarl ) );

    return "owners/index";
  }
}
