package com.francalino.frankley.castelo.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Execucao;
import com.francalino.frankley.castelo.repo.ExecucaoRepo;
import com.francalino.frankley.comum.servico.AuditavelCrudServ;

@Service
public class ExecucaoServ extends AuditavelCrudServ<Execucao>{
		
	public ExecucaoServ(ExecucaoRepo repo) {
		super(repo);
	}
			
}
