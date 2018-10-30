package com.kmakrutin.petclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Visit;
import com.kmakrutin.petclinic.service.VisitService;

@Service
@Profile( { "default", "map" } )
public class VisitMapService extends AbstractMapService<Visit> implements VisitService
{
}
