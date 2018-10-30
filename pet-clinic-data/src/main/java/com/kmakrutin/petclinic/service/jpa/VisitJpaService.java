package com.kmakrutin.petclinic.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Visit;
import com.kmakrutin.petclinic.repository.VisitRepository;
import com.kmakrutin.petclinic.service.VisitService;

@Service
@Profile( "springdatajpa" )
public class VisitJpaService extends AbstractJpaService<Visit> implements VisitService
{
  VisitJpaService( VisitRepository visitRepository )
  {
    super( visitRepository );
  }
}
