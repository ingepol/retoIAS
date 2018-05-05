package com.ias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ias.domain.Zone;
import com.ias.jpa.ZoneRepository;

@Service
public class ZoneService implements GenericService<Zone, Long> {
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	public ZoneService(ZoneRepository zoneRepository) {
		this.zoneRepository = zoneRepository;
	}
	
	@Override
	public CrudRepository<Zone, Long> getRepository() {
		return this.zoneRepository;
	}

	@Override
	public Long getId(Zone entity) {
		return entity.getCodigo();
	}
	
	@Override
	public Zone save(Zone entity) {
		return GenericService.super.save(entity);
	}

}
