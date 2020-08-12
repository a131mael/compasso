package com.abimael.teste.compasso.repository.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abimael.teste.compasso.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	public Optional<List<Cliente>> findByNomeStartsWith(String nome);
}
