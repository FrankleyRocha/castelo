package com.francalino.frankley.castelo.api.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.api.modelo.Tarefa;
import com.francalino.frankley.castelo.api.repo.TarefaRepo;

@Service
public class TarefaServ {
	
	private TarefaRepo repo;
	
	public List<Tarefa> listar(){
		return repo.findAll();
	}

}
