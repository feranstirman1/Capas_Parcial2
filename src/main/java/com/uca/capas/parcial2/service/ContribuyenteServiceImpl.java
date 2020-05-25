package com.uca.capas.parcial2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.ContribuyenteDAO;
import com.uca.capas.parcial2.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{

	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.insert(contribuyente);
	}

}
