package com.francalino.frankley.castelo.api.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.api.modelo.Tarefa;
import com.francalino.frankley.castelo.api.repo.TarefaRepo;

@Service
public class TarefaServ extends IdentificavelCrudServ<Tarefa>{
	
	public TarefaServ(TarefaRepo repo) {
		super(repo);
	}
	
}
