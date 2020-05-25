package com.uca.capas.parcial2.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_contribuyente")
	private Integer  cContribuyente;
	
	@Transient
	private Integer cImportancia;
	
	@Size(message = "Nombre puede tener mas de 30 caracteres",max=30,min=1)
	@NotEmpty(message="Este campo no puede quedar vacio")
	@Column(name="s_nombre")
	private String nombre;
	
	@Column(name="s_apellido")
	@Size(message = "No puede tener mas de 30 caracteres",max=30,min=1)
	@NotEmpty(message="Apellido no puede quedar vacio")
	private String apellido;
	
	@Column(name="s_nit")
	@Pattern(regexp="^[0-9]+$",message="El NIT solo debe de contener números")
	@Size(message = "No puede tener mas de 14 caracteres",max=14,min=1)
	@NotEmpty(message="NIT no puede quedar vacio")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fechaIngreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	public Importancia getImportancia() {
		return importancia;
	}
	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
	public Integer getcContribuyente() {
		return cContribuyente;
	}
	public void setcContribuyente(Integer cContribuyente) {
		this.cContribuyente = cContribuyente;
	}
	public Integer getcImportancia() {
		return cImportancia;
	}
	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String fechaDelegate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.fechaIngreso);
	}
	
	
	
}
