package com.francalino.frankley.castelo.api.modelo;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
abstract class Descritivel extends Identificavel{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String titulo;
	private String descricao;
				
}
