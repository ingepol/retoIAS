package com.ias.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query("SELECT distinct b FROM Bird b JOIN b.countries c "
			+ " JOIN c.zone z "
			+ "WHERE z.code = :zoneCode")
	public Iterable<Bird> findByZone(@Param("zoneCode") Long zoneCode);
	
	@Query("SELECT distinct b FROM Bird b join b.countries c "
			+ " JOIN c.zone z "
			+ "WHERE z.code = :zoneCode "
			+ "AND ( upper(b.commonName) like CONCAT('%',UPPER(:name),'%') "
			+ "OR upper(b.scientificName) like CONCAT('%',UPPER(:name),'%') )")
	public Iterable<Bird> findByName(@Param("zoneCode") Long zoneCode, @Param("name") String name);

}
