package com.francalino.frankley.castelo.modelo;

import com.francalino.frankley.comum.modelo.Auditavel;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Auditavel {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;	

}
