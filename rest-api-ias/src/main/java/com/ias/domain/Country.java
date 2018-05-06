package com.ias.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Clase dominio para persistir la información correspondiente a los paises
 * 
 * @author Paul Arenas
 *
 */
@Entity
@Table(name = "TONT_PAISES")
public class Country implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CDPAIS")
	private Long code;

	@NotNull
	@Size(max = 100)
	@Column(name = "DSNOMBRE")
	private String name;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumns({ @JoinColumn(name = "CDZONA", referencedColumnName = "CDZONA") })
	private Zone zone;

	@ManyToMany(targetEntity=Bird.class)
	private List<Bird> birds = new ArrayList<>();

	public Country() {
	}

	public Country(String name, Zone zone) {
		this.name = name;
		this.zone = zone;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
