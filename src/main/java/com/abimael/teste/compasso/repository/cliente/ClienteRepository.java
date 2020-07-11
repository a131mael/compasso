package com.abimael.teste.compasso.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abimael.teste.compasso.model.Cliente;

@Repository
public interface ClienteRepository extends ClienteRepositoryCustom, JpaRepository<Cliente, Long>  {
	
}
