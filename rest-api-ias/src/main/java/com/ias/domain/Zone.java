package com.ias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CDZONE")
	private Long codigo;
	
	@Column(name="DSNOMBRE")
	private String name;
	
	public Zone() {}

	public Zone(String name) {
		this.name = name;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Zone [codigo=" + codigo + ", name=" + name + "]";
	}
	
}
