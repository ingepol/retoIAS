package com.ias.rest.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/zones")
public class ZoneController {
	private final ZoneService zoneService;

	public ZoneController(final ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Iterable<Zone>>> findAll() {
		return ResponseEntity.ok(new Response<>(zoneService.findAll()));
	}
	
	
	@GetMapping(value = "/{zoneId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Optional<Zone>>> get(@PathVariable("zoneId") Long zoneId) {
		return ResponseEntity.ok(new Response<>(zoneService.get(zoneId)));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Zone>> createUser(@RequestBody Zone zone) {
		Zone savedZone = zoneService.save(zone);
		return ResponseEntity.created(URI.create("/" + savedZone.getCodigo())).body(new Response<>(savedZone));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody Zone zone) {
		zoneService.update(zone);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{zoneId}")
	public ResponseEntity<Response<Long>> delete(@PathVariable("zoneId") Long zoneId) {
		zoneService.delete(zoneId);
		return ResponseEntity.ok(new Response<>(zoneId));
	}
	
}
