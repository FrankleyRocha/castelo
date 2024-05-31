package com.francalino.frankley.comum.servico;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francalino.frankley.comum.modelo.Auditavel;

public abstract class AuditavelCrudServ<T extends Auditavel> extends IdentificavelCrudServ<T> {

	protected JpaRepository<T, UUID> repo;
	
	public AuditavelCrudServ(JpaRepository<T, UUID> repo) {
		super(repo);
		this.repo = repo;
	}

	@Override
	public T criar(T o) {

		o.setCriacao(new Date());
		
		return super.criar(o);
	}

	@Override
	public T atualizar(T o) {

		o.setModificacao(new Date());
		
		return super.atualizar(o);
	}
	
	
	
}
