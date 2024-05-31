package com.francalino.frankley.castelo.api.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francalino.frankley.castelo.api.modelo.Execucao;

@Repository
public interface ExecucaoRepo extends JpaRepository<Execucao,UUID>{

}
