package com.francalino.frankley.castelo.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRest {
	
	@GetMapping
	public String ola() {
		
		return "Olá Mundo!";
		
	}

}
