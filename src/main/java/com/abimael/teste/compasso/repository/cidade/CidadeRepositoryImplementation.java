package com.abimael.teste.compasso.repository.cidade;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.abimael.teste.compasso.model.Cidade;

@Transactional
public class CidadeRepositoryImplementation implements CidadeRepositoryCustom {

	@Autowired
	@Qualifier("cidadeRepository")
	private CidadeRepository obraRepository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Optional<Cidade> findByName(String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c From Cidade c ");
		sql.append("where 1=1 ");
		sql.append("and c.name = :nameCity");

		Query query = em.createQuery(sql.toString());

		query.setParameter("nameCity", name);
		Cidade city = (Cidade) query.getSingleResult();
		Optional<Cidade> opt = Optional.ofNullable(city);
		return opt;
	}

	@Override
	public Optional<List<Cidade>> findByState(String state) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c From City c ");
		sql.append("where 1=1 ");
		sql.append("and c.state = :state");

		Query query = em.createQuery(sql.toString());

		query.setParameter("state", state);

		@SuppressWarnings("unchecked")
		List<Cidade> cities = (List<Cidade>) query.getResultList();
		Optional<List<Cidade>> opt = Optional.ofNullable(cities);
		return opt;
	}

}
