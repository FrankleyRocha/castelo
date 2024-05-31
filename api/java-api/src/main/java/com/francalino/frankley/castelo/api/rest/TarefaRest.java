package com.francalino.frankley.castelo.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Tarefa> listar() {
		
		return serv.listar();
		
	}
	
	@PostMapping
	public Tarefa salvar(@RequestBody Tarefa o) {
		return serv.salvar(o);
	}

}
