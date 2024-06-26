package com.francalino.frankley.castelo.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francalino.frankley.comum.modelo.Auditavel;
import com.francalino.frankley.comum.modelo.Identificavel;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Execucao extends Auditavel {
	
	private static final long serialVersionUID = 1L;
	
	private Date inicio;
	private Date fim;
	private String observacao;
	
	@JsonIgnore @ManyToOne
	private Tarefa tarefa;
	
}
