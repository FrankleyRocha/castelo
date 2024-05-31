package com.francalino.frankley.castelo.api.modelo;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Execucao {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID) @EqualsAndHashCode.Include
	private UUID id;	
	private Date inicio;
	private Date fim;
	private String observacao;
	
	@ManyToOne
	private Tarefa tarefa;
	
}