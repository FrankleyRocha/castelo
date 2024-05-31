package com.francalino.frankley.castelo.api.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Tarefa extends Descritivel{
	
	@ManyToOne
	private Status status;
	
	@OneToMany(mappedBy = "tarefa")
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "tarefa")
	private List<Execucao> execucoes = new ArrayList<>();
	
}
