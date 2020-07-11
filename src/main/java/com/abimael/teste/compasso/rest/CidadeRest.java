package com.abimael.teste.compasso.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abimael.teste.compasso.model.Cidade;
import com.abimael.teste.compasso.repository.cidade.CidadeRepository;

@RestController	
@RequestMapping({"/cidades"})
public class CidadeRest {

	private CidadeRepository repository;

	CidadeRest(CidadeRepository repository) {
	       this.repository = repository;
	 }
		
	@GetMapping(path = {"/name/{name}"})
	public ResponseEntity<Cidade> findByName(@PathVariable String name){
	   return repository.findByName(name).map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/state/{state}"})
	public ResponseEntity<List<Cidade>> findByState(@PathVariable String state){
	   return repository.findByState(state).map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cidade create(@RequestBody Cidade contact){
	   return repository.save(contact);
	}
}
