package com.francalino.frankley.castelo.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.repo.TarefaRepo;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

@Service
public class TarefaServ extends IdentificavelCrudServ<Tarefa>{
	
	public TarefaServ(TarefaRepo repo) {
		super(repo);
	}
	
}
