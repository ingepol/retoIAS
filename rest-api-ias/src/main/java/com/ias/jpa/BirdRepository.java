package com.ias.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ias.domain.Bird;

/**
 * Interfaz del repositorio Jpa para persistir la información correspondiente a las aves
 * 
 * @author Paul Arenas
 *
 */
@Transactional
public interface BirdRepository extends JpaRepository<Bird, Long> {

}
