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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "public",name = "cat_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer codigo;
	
	@Column(name="s_categoria")
	@Size(max=50,message="El campo sobrepasa la cantidad de 50 caracteres")
	@NotEmpty(message = "El campo nombre categoria no puede estar vacio")
	private String nombre;
	
	@OneToMany(mappedBy = "categoria",fetch = FetchType.EAGER)
	private List<Libro> libros;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}