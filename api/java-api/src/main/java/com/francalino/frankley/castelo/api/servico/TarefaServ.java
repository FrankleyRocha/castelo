package com.francalino.frankley.castelo.api.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.api.modelo.Tarefa;
import com.francalino.frankley.castelo.api.repo.TarefaRepo;

@Service
public class TarefaServ {
	
	@Autowired
	private TarefaRepo repo;
	
	public List<Tarefa> listar(){
		return repo.findAll();
	}
	
	public Tarefa salvar(Tarefa o) {
		return repo.save(o);
	}

}
