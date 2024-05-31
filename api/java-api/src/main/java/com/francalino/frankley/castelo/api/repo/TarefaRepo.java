package com.francalino.frankley.castelo.api.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francalino.frankley.castelo.api.modelo.Tarefa;

@Repository
public interface TarefaRepo extends JpaRepository<Tarefa,UUID>{

}
