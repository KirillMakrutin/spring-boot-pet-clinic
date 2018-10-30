package com.kmakrutin.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true, exclude = { "petType", "owner", "visits" } )
@Entity
public class Pet extends BaseEntity
{
  private LocalDate birthDate;
  private String name;

  @ManyToOne
  @JoinColumn( name = "type_id" )
  private PetType petType;

  @ManyToOne
  @JoinColumn( name = "owner_id" )
  private Owner owner;

  @OneToMany( cascade = CascadeType.ALL, mappedBy = "pet" )
  private Set<Visit> visits = new HashSet<>();

}
