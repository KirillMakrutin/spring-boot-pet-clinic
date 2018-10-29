package com.kmakrutin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.kmakrutin.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
}
