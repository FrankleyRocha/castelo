package com.francalino.frankley.comum.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.francalino.frankley.comum.modelo.Identificavel;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

public class IdentificavelCrudRest<T extends Identificavel> {
	
	
	public IdentificavelCrudRest(IdentificavelCrudServ<T> serv) {
		this.serv = serv;
	}
	
	protected IdentificavelCrudServ<T> serv;
	
	@GetMapping
	public ResponseEntity<List<T>> listar() {
		
		return ResponseEntity.ok(
			serv.listar()
		);
		
	}
	
	@PostMapping
	public ResponseEntity<T> novo(@RequestBody T o) {
		return ResponseEntity.ok(
			serv.criar(o)
		);
	}
	
	@PatchMapping
	public ResponseEntity<T> editar(@RequestBody T o) {
		return ResponseEntity.ok(
			serv.atualizar(o)
		);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> recupear(@PathVariable UUID id) {
		
		T o = serv.recuperar(id);
		
		return ResponseEntity.ok(
			o
		);
	} 

}
