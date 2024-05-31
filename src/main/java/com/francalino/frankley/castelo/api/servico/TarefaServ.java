package com.francalino.frankley.castelo.api.servico;

import java.util.List;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
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
	
	public Tarefa criar(Tarefa o) {
		
		if(o.getId() != null)
			throw new IllegalArgumentException("[Id] deve ser nulo!");
		
		return repo.save(o);
	}
	
	public Tarefa atualizar(Tarefa o) {
		
		if(o.getId() == null)
			throw new IllegalArgumentException("[Id] não deve ser nulo!");
		
		recuperar(o.getId());
		
		return repo.save(o);
		
	}
	
	public void deletar(UUID id) {
		
		Tarefa o = recuperar(id);		
		repo.delete(o);
		
	}
	
	public Tarefa recuperar(UUID id) {
		return repo.findById(id).orElseThrow(
			()-> new ObjectNotFoundException(id, "Tarefa")
		);
	}

}
