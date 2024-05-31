package com.francalino.frankley.comum.servico;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.francalino.frankley.comum.modelo.Identificavel;

public abstract class IdentificavelCrudServ<T extends Identificavel> {
	
	protected JpaRepository<T, UUID> repo;
	
	protected Class<T> classe;
	
	public IdentificavelCrudServ(JpaRepository<T, UUID> repo) {
		this.classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.repo = repo;
	}
	
	public List<T> listar(){
		return repo.findAll();
	}
	
	public T criar(T o) {
				
		if(o.getId() != null)
			throw new IllegalArgumentException("[Id] deve ser nulo!");
		
		return repo.save(o);
	}
	
	public T atualizar(T o) {
		
		if(o.getId() == null)
			throw new IllegalArgumentException("[Id] não deve ser nulo!");
		
		recuperar(o.getId());
		
		return repo.save(o);
		
	}
	
	public void deletar(UUID id) {
		
		T o = recuperar(id);		
		repo.delete(o);
		
	}
	
	public T recuperar(UUID id) {
		return repo.findById(id).orElseThrow(
			()-> new ObjectNotFoundException(id, classe.getSimpleName())
		);
	}

}
