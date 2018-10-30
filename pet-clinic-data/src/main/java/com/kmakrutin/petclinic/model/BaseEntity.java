package com.kmakrutin.petclinic.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode( of = { "id" } )
@MappedSuperclass
public class BaseEntity implements Serializable
{
  @Id
  @GeneratedValue
  private Long id;

}
