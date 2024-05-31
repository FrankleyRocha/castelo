package com.francalino.frankley.castelo.modelo;

import com.francalino.frankley.comum.modelo.Descritivel;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Status extends Descritivel{
	
	private static final long serialVersionUID = 1L;
	
}
