package com.francalino.frankley.castelo.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francalino.frankley.comum.modelo.Descritivel;

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
	
	public static final String STATUS_PADRAO = "A_FAZER";
	
	private Long indice;
			
	@ManyToOne
	private Status status;
		
	@JsonIgnore @OneToMany(mappedBy = "tarefa")
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	@JsonIgnore @OneToMany(mappedBy = "tarefa")
	private List<Execucao> execucoes = new ArrayList<>();
	
}
