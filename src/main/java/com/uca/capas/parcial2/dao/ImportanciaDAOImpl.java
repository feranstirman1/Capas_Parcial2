package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(name = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> importancias = query.getResultList();
		return importancias;
	}

	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return entityManager.find(Importancia.class, codigo);
	}

}
