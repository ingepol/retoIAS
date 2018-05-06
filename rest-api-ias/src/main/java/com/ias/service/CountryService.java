package com.ias.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ias.domain.Country;
import com.ias.domain.Zone;
import com.ias.jpa.CountryRepository;

/**
 * Servicio emcargado de manejar la lógica y solicitar la persistencia de 
 * la información correspondiente a los paises
 * 
 * @author Paul Arenas
 *
 */
@Service
public class CountryService implements GenericService<Country, Long> {

  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private ZoneService zoneService;

  @PostConstruct
  @Transactional
  public void populate() {
	  Zone zoneA = zoneService.get(1L).get();
	  Zone zoneB = zoneService.get(2L).get();
	  Zone zoneC = zoneService.get(3L).get();
	  Country countryA = new Country("Colombia", zoneA);
      Country countryB = new Country("Argentica", zoneA);
      Country countryC = new Country("Cuba", zoneB);
      Country countryD = new Country("Francia", zoneC);
      countryRepository.saveAndFlush(countryA);
      countryRepository.saveAndFlush(countryB);
      countryRepository.saveAndFlush(countryC);
      countryRepository.saveAndFlush(countryD);
  }

  public CountryService(CountryRepository zoneRepository, ZoneService zoneService) {
    this.countryRepository = zoneRepository;
    this.zoneService = zoneService;
  }

  @Override
  public CrudRepository<Country, Long> getRepository() {
    return this.countryRepository;
  }

  @Override
  public Long getId(Country entity) {
    return entity.getCode();
  }

  @Override
  public Country save(Country entity) {
    return GenericService.super.save(entity);
  }

}
