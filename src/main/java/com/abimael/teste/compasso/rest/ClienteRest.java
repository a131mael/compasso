package com.abimael.teste.compasso.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abimael.teste.compasso.model.Cliente;
import com.abimael.teste.compasso.repository.cliente.ClienteRepository;

@RestController	
@RequestMapping({"/clientes"})
public class ClienteRest {

	private ClienteRepository repository;

	ClienteRest(ClienteRepository repository) {
	       this.repository = repository;
	 }
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/name/{name}"})
	public ResponseEntity<Cliente> findByName(@PathVariable String name){
	   return repository.findByName(name).map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente contact){
	   return repository.save(contact);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente contact) {
	   return repository.findById(id).map(record -> {
	               record.setNome(contact.getNome());
	               Cliente updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById(id).map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
