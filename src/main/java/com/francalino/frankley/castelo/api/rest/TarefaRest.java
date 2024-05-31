package com.francalino.frankley.castelo.api.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francalino.frankley.castelo.api.modelo.Tarefa;
import com.francalino.frankley.castelo.api.servico.TarefaServ;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRest {
	
	@Autowired
	private TarefaServ serv;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> listar() {
		
		return ResponseEntity.ok(
			serv.listar()
		);
		
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> novo(@RequestBody Tarefa o) {
		return ResponseEntity.ok(
			serv.criar(o)
		);
	}
	
	@PatchMapping
	public ResponseEntity<Tarefa> editar(@RequestBody Tarefa o) {
		return ResponseEntity.ok(
			serv.atualizar(o)
		);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> recupear(@PathVariable UUID id) {
		
		Tarefa o = serv.recuperar(id);
		
		return ResponseEntity.ok(
			o
		);
	} 

}
