package com.pruebaSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.pruebaSpringBoot.model.Direccion;

public interface DireccionService {
	
    List<Direccion> getAccounts();
	
	Optional<Direccion> getAccountById (Integer id);
	
	Direccion createAccount(Direccion direccion);
	
	Optional<Direccion> updateAccount(Integer id, Direccion direccion);
	
	void deleteAccount(Integer id);

}
