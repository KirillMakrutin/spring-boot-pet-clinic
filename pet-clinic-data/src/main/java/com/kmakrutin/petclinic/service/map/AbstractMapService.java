package com.kmakrutin.petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.kmakrutin.petclinic.model.BaseEntity;
import com.kmakrutin.petclinic.service.CrudService;

public class AbstractMapService<T extends BaseEntity> implements CrudService<T, Long>
{
  private Map<Long, T> map = new HashMap<>();

  @Override
  public T findById( Long id )
  {
    return map.get( id );
  }

  @Override
  public T save( T entity )
  {
    if ( entity.getId() == null )
    {
      entity.setId( map.size() + 1L );
    }

    map.put( entity.getId(), entity );

    return entity;
  }

  @Override
  public Set<T> findAll()
  {
    return new HashSet<>( map.values() );
  }

  @Override
  public void delete( T entity )
  {
    map.values().removeIf( curEntity -> curEntity.equals( entity ) );
  }

  @Override
  public void deleteById( Long id )
  {
    map.remove( id );
  }
}
