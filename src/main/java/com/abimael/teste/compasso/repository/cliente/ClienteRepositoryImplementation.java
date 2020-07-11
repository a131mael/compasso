package com.abimael.teste.compasso.repository.cliente;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.abimael.teste.compasso.model.Cliente;
import com.abimael.teste.compasso.repository.cidade.CidadeRepository;

@Transactional
public class ClienteRepositoryImplementation implements ClienteRepositoryCustom {

	@Autowired
	@Qualifier("clienteRepository")
	private CidadeRepository obraRepository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Optional<Cliente> findByName(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c From Cliente c ");
		sql.append("where 1=1 ");
		sql.append("and c.nome = :nomeCliente");

		Query query = em.createQuery(sql.toString());

		query.setParameter("nomeCliente", nome);
		Cliente cliente = (Cliente) query.getSingleResult();
		Optional<Cliente> opt = Optional.ofNullable(cliente);
		return opt;
	}
}
