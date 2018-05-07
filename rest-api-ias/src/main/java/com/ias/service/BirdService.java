package com.ias.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ias.domain.Bird;
import com.ias.domain.Country;
import com.ias.jpa.BirdRepository;

/**
 * Servicio emcargado de manejar la lógica y solicitar la persistencia de la
 * información correspondiente a las aves
 * 
 * @author Paul Arenas
 *
 */
@Service
public class BirdService implements GenericService<Bird, Long> {

	@Autowired
	private BirdRepository birdRepository;

	@Autowired
	private CountryService countryService;

	@PostConstruct
	@Transactional
	public void populate() {

		Country countryA = countryService.get(1L).get();
		Country countryB = countryService.get(2L).get();
		Country countryC = countryService.get(3L).get();
		Country countryD = countryService.get(4L).get();

		Bird birdA = new Bird("Lorito pequeño", "Bolborhynchus ferrugineifrons");
		Bird birdB = new Bird("Colibri", "Chlorostilbon olivaresi");
		Bird birdC = new Bird("Trogón tocororo", "Priotelus temnuru");
		Bird birdD = new Bird("Cisne negro", "Cygnus atratus");

		birdA.getCountries().add(countryA);
		birdB.getCountries().add(countryB);
		birdB.getCountries().add(countryB);
		birdC.getCountries().add(countryC);
		birdD.getCountries().add(countryD);

		birdRepository.saveAndFlush(birdA);
		birdRepository.saveAndFlush(birdB);
		birdRepository.saveAndFlush(birdC);
		birdRepository.saveAndFlush(birdD);
	}

	public BirdService(BirdRepository birdRepository, CountryService countryService) {
		this.birdRepository = birdRepository;
		this.countryService = countryService;
	}

	@Override
	public CrudRepository<Bird, Long> getRepository() {
		return this.birdRepository;
	}

	@Override
	public Long getId(Bird entity) {
		return entity.getCode();
	}

	@Override
	public Bird save(Bird entity) {
		return GenericService.super.save(entity);
	}

	public Iterable<Bird> findByZone(Long zoneCode) {
		return birdRepository.findByZone(zoneCode);
	}
	
	public Iterable<Bird> findByName(Long zoneCode, String name) {
		return birdRepository.findByName(zoneCode, name);
	}

}
