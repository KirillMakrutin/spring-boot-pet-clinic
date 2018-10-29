package com.kmakrutin.petclinic.service.jpa;


import java.util.Set;

import com.kmakrutin.petclinic.model.BaseEntity;
import com.kmakrutin.petclinic.repository.WrappedCrudRepository;
import com.kmakrutin.petclinic.service.CrudService;

public class AbstractJpaService<T extends BaseEntity> implements CrudService<T, Long>
{
  private final WrappedCrudRepository<T, Long> crudRepository;

  AbstractJpaService( WrappedCrudRepository<T, Long> crudRepository )
  {
    this.crudRepository = crudRepository;
  }

  @Override
  public T findById( Long id )
  {
    return crudRepository.findById( id ).orElse( null );
  }

  @Override
  public T save( T entity )
  {
    return crudRepository.save( entity );
  }

  @Override
  public Set<T> findAll()
  {
    return crudRepository.findAll();
  }

  @Override
  public void delete( T entity )
  {
    crudRepository.delete( entity );
  }

  @Override
  public void deleteById( Long id )
  {
    crudRepository.deleteById( id );
  }
}
