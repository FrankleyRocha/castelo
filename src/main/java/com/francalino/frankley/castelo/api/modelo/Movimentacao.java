package com.francalino.frankley.castelo.api.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Movimentacao extends Identificavel {
	
	private static final long serialVersionUID = 1L;
		
	private Date momento;
	
	@ManyToOne @JsonIgnore
	private Tarefa tarefa;
	
	@ManyToOne
	private Status statusAnterior;
	
	@ManyToOne
	private Status status;
	
}
