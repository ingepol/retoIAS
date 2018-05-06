package com.ias.rest.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ias.domain.Country;
import com.ias.response.Response;
import com.ias.service.CountryService;

/**
 * Controlador encargado de mapear y recibir las peticiones Rest correspondiente 
 * al manejo de las paises
 * 
 * @author Paul Arenas
 *
 */
@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 3000)
public class CountryController {
	private final CountryService countryService;

	public CountryController(final CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Iterable<Country>>> findAll() {
		return ResponseEntity.ok(new Response<>(countryService.findAll(),200));
	}
	
	@GetMapping(value = "/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Optional<Country>>> get(@PathVariable("countryId") Long countryId) {
		return ResponseEntity.ok(new Response<>(countryService.get(countryId),200));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Country>> create(@RequestBody Country country) {
		Country savedCountry = countryService.save(country);
		return ResponseEntity.created(URI.create("/" + savedCountry.getCode())).body(new Response<>(savedCountry,200));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Country country) {
		countryService.update(country);
		return ResponseEntity.ok(new Response<>(country,200));
	}
	
	@DeleteMapping(value = "/{countryId}")
	public ResponseEntity<Response<Long>> delete(@PathVariable("countryId") Long countryId) {
		countryService.delete(countryId);
		return ResponseEntity.ok(new Response<>(countryId,200));
	}
	
}
