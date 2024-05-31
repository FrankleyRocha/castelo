package com.francalino.frankley.castelo.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Execucao;
import com.francalino.frankley.castelo.repo.ExecucaoRepo;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

@Service
public class ExecucaoServ extends IdentificavelCrudServ<Execucao>{
		
	public ExecucaoServ(ExecucaoRepo repo) {
		super(repo);
	}
			
}
