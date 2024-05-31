package com.francalino.frankley.castelo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.servico.TarefaServ;
import com.francalino.frankley.comum.rest.IdentificavelCrudRest;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRest extends IdentificavelCrudRest<Tarefa>{
	
	public TarefaRest(TarefaServ serv) {
		super(serv);
	}
	
}
