package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Categoria;


public interface CategoriaService {

	public List<Categoria> findAll() throws DataAccessException;
	public Categoria findOne(Integer codigo) throws DataAccessException;
	public void insert(Categoria categoria) throws DataAccessException;
}
