package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@PersistenceContext(name="capas")
	EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> libros = query.getResultList();
		return libros;
	}

	@Override
	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(libro);
	}

}