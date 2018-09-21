package com.kmakrutin.petclinic.service.map;

import org.springframework.stereotype.Service;

import com.kmakrutin.petclinic.model.Vet;
import com.kmakrutin.petclinic.service.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService
{
}
