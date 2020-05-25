package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Contribuyente;
import com.uca.capas.parcial2.domain.Importancia;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {

	@PersistenceContext(name = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> contribuyente = query.getResultList();
		return contribuyente;
	}

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(contribuyente);
	}

}
