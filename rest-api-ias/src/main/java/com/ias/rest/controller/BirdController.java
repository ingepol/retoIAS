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

import com.ias.domain.Bird;
import com.ias.response.Response;
import com.ias.service.BirdService;
import com.ias.service.exception.GenericServiceException;

/**
 * Controlador encargado de mapear y recibir las peticiones Rest correspondiente al manejo de las
 * aves
 * 
 * @author Paul Arenas
 *
 */
@RestController
@RequestMapping("/birds")
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 3000)
public class BirdController {
  private final BirdService birdService;

  public BirdController(final BirdService birdService) {
    this.birdService = birdService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<Iterable<Bird>>> findAll() {
    return ResponseEntity.ok(new Response<>(birdService.findAll(), 200));
  }
  
  @GetMapping(value = "/search/{zoneCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<Iterable<Bird>>> findBirds(@PathVariable("zoneCode") Long zoneCode) {
    return ResponseEntity.ok(new Response<>(birdService.findByZone(zoneCode), 200));
  }
  
  @GetMapping(value = "/search/{zoneCode}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<Iterable<Bird>>> findBirds(@PathVariable("zoneCode") Long zoneCode, @PathVariable("name") String name) {
    return ResponseEntity.ok(new Response<>(birdService.findByName(zoneCode, name), 200));
  }

  @GetMapping(value = "/{birdId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<Optional<Bird>>> get(@PathVariable("birdId") Long birdId) {
    return ResponseEntity.ok(new Response<>(birdService.get(birdId), 200));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<Bird>> create(@RequestBody Bird bird) {
    Bird savedBird = null;
    try {
      savedBird = birdService.save(bird);
    } catch (GenericServiceException gse) {
      return ResponseEntity.badRequest()
          .body(new Response<>(null, 400, gse.getMessage()));
    }
    return ResponseEntity.created(URI.create("/" + savedBird.getCode()))
        .body(new Response<>(savedBird, 200));
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> update(@RequestBody Bird bird) {
    try {
      birdService.update(bird);
      return ResponseEntity.ok(new Response<>(bird, 200));
    } catch (GenericServiceException gse) {
      return ResponseEntity.badRequest()
          .body(new Response<>(null, 400, gse.getMessage()));
    }

  }

  @DeleteMapping(value = "/{birdId}")
  public ResponseEntity<Response<Long>> delete(@PathVariable("birdId") Long birdId) {
    birdService.delete(birdId);
    return ResponseEntity.ok(new Response<>(birdId, 200));
  }

}
