package com.francalino.frankley.comum.modelo;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Descritivel extends Identificavel{
		
	private static final long serialVersionUID = 1L;
		
	private String nome;
	private String titulo;
	private String descricao;
				
}
