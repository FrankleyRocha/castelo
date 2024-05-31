package com.francalino.frankley.castelo.api.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
	private List<Execucao> execucoes = new ArrayList<>();
	
}
