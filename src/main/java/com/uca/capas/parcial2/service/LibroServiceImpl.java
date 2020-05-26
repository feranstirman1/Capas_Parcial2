package com.uca.capas.parcial2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.LibroDAO;
import com.uca.capas.parcial2.domain.Libro;



@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.insert(libro);
	}

}
