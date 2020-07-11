package com.abimael.teste.compasso.repository.cidade;

import java.util.List;
import java.util.Optional;

import com.abimael.teste.compasso.model.Cidade;
	
public interface CidadeRepositoryCustom {

	public Optional<Cidade> findByName(String name);
	
	public Optional<List<Cidade>> findByState(String state);
}
