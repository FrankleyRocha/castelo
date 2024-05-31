package com.francalino.frankley.castelo.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francalino.frankley.castelo.modelo.Execucao;
import com.francalino.frankley.castelo.modelo.Movimentacao;
import com.francalino.frankley.castelo.modelo.Tarefa;
import com.francalino.frankley.castelo.servico.TarefaServ;
import com.francalino.frankley.comum.rest.IdentificavelCrudRest;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaRest extends IdentificavelCrudRest<Tarefa>{
	
	@Autowired
	private TarefaServ serv;
	
	public TarefaRest(TarefaServ serv) {
		super(serv);
		//this.serv = serv;
	}
	
	@GetMapping("/{id}/movimentacoes")
	public List<Movimentacao> listaMovimentacoes(
		@PathVariable UUID id
	){
		return serv.listarMovimentacoes(id);
	}
	
	@GetMapping("/{id}/execucoes")
	public List<Execucao> listaExecucoes(
		@PathVariable UUID id
	){
		return serv.listarExecucoes(id);
	}
		
	@PostMapping("/movimentar")
	public Movimentacao movimentar(
		@RequestBody Tarefa t
	) {
				
		return serv.movimentar(
			t
		);
		
	}
	
	@PostMapping("/iniciarExecucao")
	public Execucao iniciarExecucao(
		@RequestBody Tarefa t
	) {
				
		return serv.iniciarExecucao(
			t
		);
		
	}
	
	@PostMapping("/finalizarExecucao")
	public Execucao finalizarExecucao(
		@RequestBody Execucao e
	) {
				
		return serv.finalizarExecucao(
			e
		);
		
	}
	
}
