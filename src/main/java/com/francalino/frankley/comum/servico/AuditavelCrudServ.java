package com.francalino.frankley.comum.servico;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

import com.francalino.frankley.comum.modelo.Auditavel;

public abstract class AuditavelCrudServ<T extends Auditavel> extends IdentificavelCrudServ<T> {

	protected JpaRepository<T, UUID> repo;
	
	public AuditavelCrudServ(JpaRepository<T, UUID> repo) {
		super(repo);
		this.repo = repo;
	}

	@Override
	public T criar(T o) {
		
		Jwt pp = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = pp.getClaimAsString("preferred_username");		
		o.setCriadoPor(usuario);

		o.setCriacao(new Date());
		
		return super.criar(o);
	}

	@Override
	public T atualizar(T o) {
		
		Jwt pp = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = pp.getClaimAsString("preferred_username");		
		o.setModificadoPor(usuario);

		o.setModificacao(new Date());
		
		return super.atualizar(o);
	}
	
	
	
}
