package com.francalino.frankley.comum.modelo;

import java.io.Serializable;
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
public abstract class Identificavel implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.UUID) @EqualsAndHashCode.Include
	protected UUID id;
		
}
