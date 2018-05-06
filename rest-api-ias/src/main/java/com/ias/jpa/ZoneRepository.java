package com.ias.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ias.domain.Zone;

/**
 * Interfaz del repositorio Jpa para persistir la información correspondiente a las zonas
 * 
 * @author Paul Arenas
 *
 */
@Transactional
public interface ZoneRepository extends JpaRepository<Zone, Long> {

}
