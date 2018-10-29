package com.kmakrutin.petclinic.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

public interface WrappedCrudRepository<T, ID> extends CrudRepository<T, ID>
{
  @Override
  Set<T> findAll();
}
