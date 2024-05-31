package com.francalino.frankley.castelo.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francalino.frankley.comum.modelo.Descritivel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Tarefa extends Descritivel{
	
	private static final long serialVersionUID = 1L;
		
	@ManyToOne
	private Status status;
	
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
	private List<Execucao> execucoes = new ArrayList<>();
	
}
