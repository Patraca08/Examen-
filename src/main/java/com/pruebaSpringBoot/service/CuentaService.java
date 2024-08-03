package com.pruebaSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.pruebaSpringBoot.model.Cuenta;

public interface CuentaService {
	
	List<Cuenta> getAccounts();
	
	Optional<Cuenta> getAccountById (Integer id);
	
	Cuenta createAccount(Cuenta cuenta);
	
	Optional<Cuenta> updateAccount(Integer id, Cuenta cuenta);
	
	void deleteAccount(Integer id);

}
