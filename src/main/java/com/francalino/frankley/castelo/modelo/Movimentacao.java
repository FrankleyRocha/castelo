package com.francalino.frankley.castelo.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francalino.frankley.comum.modelo.Auditavel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Movimentacao extends Auditavel {
	
	private static final long serialVersionUID = 1L;
			
	@JsonIgnore @ManyToOne
	private Tarefa tarefa;
	
	@ManyToOne
	private Status statusAnterior;
	
	@ManyToOne
	private Status status;
	
}
