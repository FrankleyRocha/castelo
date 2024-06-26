package com.francalino.frankley.castelo.servico;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francalino.frankley.castelo.modelo.Execucao;
import com.francalino.frankley.castelo.modelo.Movimentacao;
import com.francalino.frankley.castelo.modelo.Status;
import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.repo.TarefaRepo;
import com.francalino.frankley.comum.servico.AuditavelCrudServ;

@Service
public class TarefaServ extends AuditavelCrudServ<Tarefa>{
	
	@Autowired
	private ExecucaoServ execucaoServ;
	
	@Autowired
	private MovimentacaoServ movimentacaoServ;
	
	@Autowired
	private StatusServ statusServ;
	
	public TarefaServ(TarefaRepo repo) {
		super(repo);
	}
					
	@Override
	public Tarefa atualizar(Tarefa o) {

		Movimentacao movimentacao = movimentar(o);
		
		if(movimentacao!=null)
			return(movimentacao.getTarefa());
		else
			return super.atualizar(o);
	}

	@Override
	public Tarefa criar(Tarefa t) {
				
		t.setStatus(
			statusServ.porNome(Tarefa.STATUS_PADRAO)
		);
		
		return super.criar(t);
	}
	
	public List<Movimentacao> listarMovimentacoes(UUID id){
		
		return recuperar(id).getMovimentacoes();
		
	}
	
	public List<Execucao> listarExecucoes(UUID id){
		
		return recuperar(id).getExecucoes();
		
	}

	public Execucao iniciarExecucao(Tarefa t){
		
		Tarefa tarefa = recuperar(t.getId());
		
		Execucao execucao = new Execucao();
		execucao.setInicio(new Date());
		execucao.setTarefa(tarefa);
		
		return execucaoServ.criar(execucao);		
	}
	
	public Execucao finalizarExecucao(Execucao e){
		
		Execucao execucao = execucaoServ.recuperar(
			e.getId()
		);
		
		if(execucao.getFim() != null)
			throw new IllegalArgumentException("Execução já finalizada!");
				
		execucao.setFim(new Date());		
		execucao.setObservacao(
			e.getObservacao()
		);
		
		return execucaoServ.atualizar(execucao);		
	}
	
	public Movimentacao movimentar(Tarefa t) {
		
		Tarefa tarefa = recuperar(t.getId());
		
		Status status;
		
		if(
			t.getStatus() != null &&
			//t.getStatus().getId() == null &&
			t.getStatus().getNome() != null &&
			!t.getStatus().getNome().isBlank()
		)
			status = statusServ.porNome(t.getStatus().getNome());
		else
			status = statusServ.recuperar(t.getStatus().getId());
		
		if(status != null && !status.equals(tarefa.getStatus())){
		
			Movimentacao movimentacao = new Movimentacao();
			movimentacao.setTarefa(tarefa);
			movimentacao.setStatusAnterior(tarefa.getStatus());
			movimentacao.setStatus(status);
			
			tarefa.setStatus(status);
			atualizar(tarefa);
			
			return movimentacaoServ.criar(movimentacao);			
		}
		
		return null;
	}
	
}
