package com.uca.capas.parcial2.domain;

import java.text.DateFormat;
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
import javax.validation.constraints.Size;


@Entity
@Table(schema="public",name="cat_libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer codigo;
	
	@Column(name="s_isbn")
	@Size(message="El campo sobrepasa la cantidad de 10 caracteres",max=10)
	@NotEmpty(message="El campo isbn no puede estar vacio")
	private String isbn;
	
	@Column(name="s_titulo")
	@Size(max=500,message="El titulo sobrepasa la cantidad de 500 caracteres")
	@NotEmpty(message="El campo titulo no puede estar vacio")
	private String titulo;
	
	@Column(name = "s_autor")
	@Size(max=150,message="El nombre del autor no debe contener mas de 150 caracteres")
	@NotEmpty(message="El campo autor no puede estar vacio")
	private String autor;
	
	@Transient
	private Integer cCategoria;
	
	@Column(name="f_ingreso")
	private Date fechaIngreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;

	@Column(name="b_estado")
	private Boolean estado;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getFechaDelegate() {
		DateFormat formateador = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		return formateador.format(this.fechaIngreso);
		
	}
	
	
}

