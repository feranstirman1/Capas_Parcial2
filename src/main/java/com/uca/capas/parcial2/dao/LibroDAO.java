package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;


public interface LibroDAO {
	
	public List<Libro> findAll() throws DataAccessException;
	public void insert(Libro libro) throws DataAccessException;

}
