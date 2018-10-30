package com.kmakrutin.petclinic.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true )
@Entity
public class Specialty extends BaseEntity {
    private String description;
}
