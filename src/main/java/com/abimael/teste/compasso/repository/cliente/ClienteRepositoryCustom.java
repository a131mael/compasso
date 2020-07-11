package com.abimael.teste.compasso.repository.cliente;

import java.util.Optional;

import com.abimael.teste.compasso.model.Cliente;

public interface ClienteRepositoryCustom {

	public Optional<Cliente> findByName(String name);
}
