package com.ias.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ias.domain.Zone;
import com.ias.jpa.ZoneRepository;

/**
 * Servicio emcargado de manejar la lógica y solicitar la persistencia de 
 * la información correspondiente a las zonas
 * 
 * @author Paul Arenas
 *
 */
@Service
public class ZoneService implements GenericService<Zone, Long> {

  @Autowired
  private ZoneRepository zoneRepository;

  @PostConstruct
  @Transactional
  public void populate() {
      Zone zoneA = new Zone("Zona A");
      Zone zoneB = new Zone("Zona B");
      Zone zoneC = new Zone("Zona C");

      this.zoneRepository.saveAndFlush(zoneA);
      this.zoneRepository.saveAndFlush(zoneB);
      this.zoneRepository.saveAndFlush(zoneC);   
  }

  public ZoneService(ZoneRepository zoneRepository) {
    this.zoneRepository = zoneRepository;
  }

  @Override
  public CrudRepository<Zone, Long> getRepository() {
    return this.zoneRepository;
  }

  @Override
  public Long getId(Zone entity) {
    return entity.getCode();
  }

  @Override
  public Zone save(Zone entity) {
    return GenericService.super.save(entity);
  }

}
