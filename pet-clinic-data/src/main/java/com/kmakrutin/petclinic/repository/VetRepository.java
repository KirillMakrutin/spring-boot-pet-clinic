package com.kmakrutin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.kmakrutin.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>
{
}
