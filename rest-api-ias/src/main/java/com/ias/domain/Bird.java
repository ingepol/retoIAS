package com.ias.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase dominio para persistir la información correspondiente a las aves
 * 
 * @author Paul Arenas
 *
 */
@Entity
@Table(name = "TONT_AVES")
public class Bird implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CDAVE")
	private Long code;

	@NotNull
	@Size(max = 100)
	@Column(name = "DSNOMBRE_COMUN")
	private String commonName;

	@NotNull
	@Size(max = 200)
	@Column(name = "DSNOMBRE_CIENTIFICO")
	private String scientificName;
	
	@ManyToMany(targetEntity=Country.class)
	private List<Country> countries = new ArrayList<Country>();

	public Bird() {
	}

	public Bird(String commonName, String scientificName) {
		this.commonName = commonName;
		this.scientificName = scientificName;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}



	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Zone [code=" + code + ", scientificName=" + scientificName + ", commonName=" + commonName + "]";
	}

}
