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

import com.ias.domain.Zone;
import com.ias.response.Response;
import com.ias.service.ZoneService;

/**
 * Controlador encargado de mapear y recibir las peticiones Rest correspondiente 
 * al manejo de las zonas
 * 
 * @author Paul Arenas
 *
 */
@RestController
@RequestMapping("/zones")
@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 3000)
public class ZoneController {
	private final ZoneService zoneService;

	public ZoneController(final ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Iterable<Zone>>> findAll() {
		return ResponseEntity.ok(new Response<>(zoneService.findAll(),200));
	}
	
	@GetMapping(value = "/{zoneId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Optional<Zone>>> get(@PathVariable("zoneId") Long zoneId) {
		return ResponseEntity.ok(new Response<>(zoneService.get(zoneId),200));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Zone>> create(@RequestBody Zone zone) {
		Zone savedZone = zoneService.save(zone);
		return ResponseEntity.created(URI.create("/" + savedZone.getCode())).body(new Response<>(savedZone,200));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Zone zone) {
		zoneService.update(zone);
		return ResponseEntity.ok(new Response<>(zone,200));
	}
	
	@DeleteMapping(value = "/{zoneId}")
	public ResponseEntity<Response<Long>> delete(@PathVariable("zoneId") Long zoneId) {
		zoneService.delete(zoneId);
		return ResponseEntity.ok(new Response<>(zoneId,200));
	}
	
}
