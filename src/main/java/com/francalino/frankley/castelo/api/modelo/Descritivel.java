package com.francalino.frankley.castelo.api.modelo;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
abstract class Descritivel {

	
	@Id @GeneratedValue(strategy = GenerationType.UUID) @EqualsAndHashCode.Include
	private UUID id;
	private String nome;
	private String titulo;
	private String descricao;
	
}
