package com.ias.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ias.domain.Bird;
import com.ias.domain.Country;
import com.ias.domain.Zone;
import com.ias.jpa.BirdRepository;

public class BirdServiceTest {

  private BirdRepository birdRepository;
  private CountryService countryService;
  private BirdService birdService;
  private Bird bird;

  @Before
  public void before() {
    countryService = mock(CountryService.class);
    birdRepository = mock(BirdRepository.class);
    bird = mock(Bird.class);
    birdService = new BirdService(birdRepository, countryService);
  }

  @Test
  public void testGetId() {
    assertNotNull(Mockito.when(birdService.getId(bird)).thenReturn(1L));
  }

  @Test
  public void testSave() {
    try {
      Bird birdReturned = mockCompleteBird();
      Bird birdToCreate = mockSimpleBird();

      when(birdRepository.save(any(Bird.class))).thenReturn(birdReturned);
      Bird birdResult = birdService.save(birdToCreate);
      assertEquals(birdResult, birdReturned);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Bird mockCompleteBird() {
    Bird bird = mockSimpleBird();
    bird.setCode(1L);
    return bird;
  }

  private Bird mockSimpleBird() {
    Zone zone = new Zone();
    zone.setCode(1L);
    zone.setName("nombreZona1");
    Country country = new Country();
    country.setCode(1L);
    country.setName("nombrePais1");
    country.setZone(zone);
    List<Country> countries = new ArrayList<Country>();
    countries.add(country);
    Bird bird = new Bird();
    bird.setCommonName("nombreComun1");
    bird.setScientificName("nombreScientifico1");
    bird.setCountries(countries);
    return bird;
  }
}
