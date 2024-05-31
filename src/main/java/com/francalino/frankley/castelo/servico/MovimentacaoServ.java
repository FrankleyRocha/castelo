package com.francalino.frankley.castelo.servico;

import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Movimentacao;
import com.francalino.frankley.castelo.repo.MovimentacaoRepo;
import com.francalino.frankley.comum.servico.AuditavelCrudServ;

@Service
public class MovimentacaoServ extends AuditavelCrudServ<Movimentacao>{
		
	public MovimentacaoServ(MovimentacaoRepo repo) {
		super(repo);
	}
			
}
