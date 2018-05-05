package com.ias.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ias.domain.Zone;

@Transactional
public interface ZoneRepository extends JpaRepository<Zone, Long> {

}
