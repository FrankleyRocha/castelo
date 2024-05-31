package com.francalino.frankley.castelo.api.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francalino.frankley.castelo.api.modelo.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status,UUID>{

}
