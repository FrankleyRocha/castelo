package com.francalino.frankley.castelo.api.modelo;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Execucao extends Identificavel {
	
	private static final long serialVersionUID = 1L;
	
	private Date inicio;
	private Date fim;
	private String observacao;
	
	@ManyToOne @JsonIgnore
	private Tarefa tarefa;
	
}
