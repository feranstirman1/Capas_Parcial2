package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.ImportanciaDAO;
import com.uca.capas.parcial2.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {

	@Autowired
	ImportanciaDAO importanciaDAO;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findAll();
	}

	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findOne(codigo);
	}

}
