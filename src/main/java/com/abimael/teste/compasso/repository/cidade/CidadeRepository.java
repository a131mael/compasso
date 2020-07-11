package com.abimael.teste.compasso.repository.cidade;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abimael.teste.compasso.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public Optional<Cidade> findByName(String name);

	public Optional<List<Cidade>> findByState(String state);
}
