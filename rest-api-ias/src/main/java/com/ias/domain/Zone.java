package com.ias.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase dominio para persistir la información correspondiente a las zonas
 * 
 * @author Paul Arenas
 *
 */
@Entity
@Table(name = "TONT_ZONAS")
public class Zone implements Serializable {

  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CDZONA")
  private Long code;

  @NotNull
  @Size(max = 45)
  @Column(name = "DSNOMBRE")
  private String name;

  public Zone() {}

  public Zone(String name) {
    this.name = name;
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
  
  @Override
  public String toString() {
    return "Zone [code=" + code + ", name=" + name + "]";
  }

}
