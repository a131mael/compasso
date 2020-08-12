package com.abimael.teste.compasso.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abimael.teste.compasso.model.Cidade;
import com.abimael.teste.compasso.model.EstadoEnum;
import com.abimael.teste.compasso.repository.cidade.CidadeRepository;

@RestController
@RequestMapping({ "/cidades" })
public class CidadeRest {

	private CidadeRepository repository;

	CidadeRest(CidadeRepository repository) {
		this.repository = repository;
	}	

	@GetMapping
	public ResponseEntity<List<Cidade>> findByNome(
			@RequestParam(defaultValue = "#") String nome,
			@RequestParam(defaultValue = "") String estado) {

		EstadoEnum estadoDefault;
		if(!estado.equalsIgnoreCase("")){
			estadoDefault = EstadoEnum.values()[Integer.valueOf(estado)];
		}else{
			estadoDefault = EstadoEnum.NULO;
		}
		return repository.findByNomeStartsWithOrEstado(nome, estadoDefault).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Cidade create(@RequestBody Cidade contact) {
		return repository.save(contact);
	}
}
