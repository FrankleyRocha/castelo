package com.francalino.frankley.comum.modelo;

import java.util.Date;

import com.francalino.frankley.castelo.modelo.Usuario;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Auditavel extends Identificavel{
		
	private static final long serialVersionUID = 1L;
		
	private Date criacao;
	private Date modificacao;
	
	@ManyToOne(optional = true)
	private Usuario criadoPor;
	
	@ManyToOne(optional = true)
	private Usuario modificadoPor;
				
}
