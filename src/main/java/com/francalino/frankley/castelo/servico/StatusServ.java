package com.francalino.frankley.castelo.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Status;
import com.francalino.frankley.castelo.repo.StatusRepo;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

@Service
public class StatusServ extends IdentificavelCrudServ<Status>{
	
	public StatusServ(StatusRepo repo) {
		super(repo);
	}
	
}
