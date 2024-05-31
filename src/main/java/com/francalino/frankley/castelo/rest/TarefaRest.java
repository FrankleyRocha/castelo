package com.francalino.frankley.castelo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francalino.frankley.castelo.modelo.Movimentacao;
import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.servico.TarefaServ;
import com.francalino.frankley.comum.rest.IdentificavelCrudRest;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRest extends IdentificavelCrudRest<Tarefa>{
	
	@Autowired
	private TarefaServ serv;
	
	public TarefaRest(TarefaServ serv) {
		super(serv);
		//this.serv = serv;
	}
	
	
	@PostMapping("/movimentar")
	public Movimentacao movimentar(
		@RequestBody Tarefa t
	) {
				
		return serv.movimentar(
			t
		);
		
	}
	
}
