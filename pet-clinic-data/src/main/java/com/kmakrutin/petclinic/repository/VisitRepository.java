package com.kmakrutin.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.kmakrutin.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>
{
}
