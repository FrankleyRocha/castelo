package com.francalino.frankley.castelo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francalino.frankley.castelo.modelo.Status;
import com.francalino.frankley.castelo.servico.StatusServ;
import com.francalino.frankley.comum.rest.IdentificavelCrudRest;

@RestController
@RequestMapping("/api/status")
public class StatusRest extends IdentificavelCrudRest<Status>{
	
	public StatusRest(StatusServ serv) {
		super(serv);
	}
	
}
