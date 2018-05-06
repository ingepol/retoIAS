package com.ias.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ias.domain.Country;

/**
 * Interfaz del repositorio Jpa para persistir la información correspondiente a los paises
 * 
 * @author Paul Arenas
 *
 */
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {

}
