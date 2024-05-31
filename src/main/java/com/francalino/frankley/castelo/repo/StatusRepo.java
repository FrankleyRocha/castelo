package com.francalino.frankley.castelo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francalino.frankley.castelo.modelo.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status,UUID>{

}
