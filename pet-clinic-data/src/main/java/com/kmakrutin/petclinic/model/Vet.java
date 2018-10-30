package com.kmakrutin.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true, exclude = { "specialties" } )
@Entity
public class Vet extends Person
{
  @ManyToMany( fetch = FetchType.EAGER )
  @JoinTable( name = "vet_specialty",
      joinColumns = @JoinColumn( name = "vet_id" ),
      inverseJoinColumns = @JoinColumn( name = "specialty_id" ) )
  private Set<Specialty> specialties = new HashSet<>();

}
