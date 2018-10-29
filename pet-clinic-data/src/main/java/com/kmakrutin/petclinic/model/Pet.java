package com.kmakrutin.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet extends BaseEntity
{
  private PetType petType;
  private Owner owner;
  private LocalDate birthDate;
  private String name;

  @ManyToOne
  @JoinColumn( name = "type_id")
  public PetType getPetType()
  {
    return petType;
  }

  public void setPetType( PetType petType )
  {
    this.petType = petType;
  }

  @ManyToOne
  @JoinColumn( name = "owner_id")
  public Owner getOwner()
  {
    return owner;
  }

  public void setOwner( Owner owner )
  {
    this.owner = owner;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate( LocalDate birthDate )
  {
    this.birthDate = birthDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
