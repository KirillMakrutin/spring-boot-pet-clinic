package com.kmakrutin.petclinic.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kmakrutin.petclinic.model.Vet;

@Controller
public class VetController
{
  @GetMapping( { "/vets", "/vets/index", "/vets/index.html" } )
  public String listVets( Model model )
  {
    Vet vetTom = new Vet();
    vetTom.setFirstName( "Tom" );
    vetTom.setLastName( "Broddy" );

    Vet vetCarl = new Vet();
    vetCarl.setFirstName( "Tom" );
    vetCarl.setLastName( "Snow" );
    model.addAttribute( "vets", Arrays.asList( vetTom, vetCarl ) );
    return "vets/index";
  }
}
