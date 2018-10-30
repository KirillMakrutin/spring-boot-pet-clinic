package com.kmakrutin.petclinic.model;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true )
@MappedSuperclass
public class Person extends BaseEntity
{
  private String firstName;
  private String lastName;

}
