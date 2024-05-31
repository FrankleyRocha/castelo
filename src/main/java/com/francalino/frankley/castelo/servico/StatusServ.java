package com.francalino.frankley.castelo.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Status;
import com.francalino.frankley.castelo.repo.StatusRepo;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

@Service
public class StatusServ extends IdentificavelCrudServ<Status>{
	
	public StatusServ(StatusRepo repo) {
		super(repo);
	}
	
		
	public List<Status> listarPorNome(String nome) {
		
		return listar().stream().filter(
			s -> s.getNome().equals(nome)
		).collect(
			Collectors.toList()
		);
						
	}
	
	public Status porNome(String nome) {
		
		return listarPorNome(nome).get(0);
		
	}
	
}
