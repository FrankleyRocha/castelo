package com.francalino.frankley.castelo.servico;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Execucao;
import com.francalino.frankley.castelo.modelo.Movimentacao;
import com.francalino.frankley.castelo.modelo.Status;
import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.repo.ExecucaoRepo;
import com.francalino.frankley.castelo.repo.MovimentacaoRepo;
import com.francalino.frankley.castelo.repo.TarefaRepo;
import com.francalino.frankley.comum.servico.IdentificavelCrudServ;

@Service
public class TarefaServ extends IdentificavelCrudServ<Tarefa>{
	
	@Autowired
	private ExecucaoRepo execucaoRepo;
	
	@Autowired
	private MovimentacaoRepo movimentacaoRepo;
	
	@Autowired
	private StatusServ statusServ;
	
	public TarefaServ(TarefaRepo repo) {
		super(repo);
	}
	
		
	@Override
	public Tarefa criar(Tarefa tarefa) {
				
		tarefa.setStatus(
			statusServ.porNome(Tarefa.STATUS_PADRAO)
		);
		
		return super.criar(tarefa);
	}

	public Execucao iniciarExecucao(Tarefa t){
		
		Execucao execucao = new Execucao();
		execucao.setInicio(new Date());
		execucao.setTarefa(t);
		
		return execucaoRepo.save(execucao);		
	}
	
	public Execucao finalizarExecucao(UUID tarefaId, String observacao){
		
		Tarefa t = recuperar(tarefaId);
		
		Execucao execucao = new Execucao();
		execucao.setTarefa(t);
		execucao.setFim(new Date());		
		execucao.setObservacao(observacao);
		
		return execucaoRepo.save(execucao);		
	}
	
	public Movimentacao movimentar(Tarefa tarefa) {
		
		Tarefa t = recuperar(tarefa.getId());
		Status s = statusServ.recuperar(tarefa.getStatus().getId());
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setTarefa(t);
		movimentacao.setStatusAnterior(t.getStatus());
		movimentacao.setStatus(s);
		movimentacao.setMomento(new Date());
		
		return movimentacaoRepo.save(movimentacao);
	}
	
}
