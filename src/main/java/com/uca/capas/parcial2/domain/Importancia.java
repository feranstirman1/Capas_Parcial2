package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="importancia")
public class Importancia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_importancia")
	private Integer cImportancia;
	
	@Column(name="s_importancia")
	private String tipoImportancia;
	
	@OneToMany(mappedBy = "importancia",fetch = FetchType.EAGER)
	private List<Contribuyente> contribuyentes;
	

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}

	public Integer getcImportancia() {
		return cImportancia;
	}

	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}

	public String getTipoImportancia() {
		return tipoImportancia;
	}

	public void setTipoImportancia(String tipoImportancia) {
		this.tipoImportancia = tipoImportancia;
	}
	
	
}
