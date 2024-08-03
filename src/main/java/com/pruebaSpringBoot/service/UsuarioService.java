package com.pruebaSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.pruebaSpringBoot.model.Usuario;

public interface UsuarioService {
	
    List<Usuario> getAccounts();
	
	Optional<Usuario> getAccountById (Integer id);
	
	Usuario createAccount(Usuario usuario);
	
	Optional<Usuario> updateAccount(Integer id, Usuario usuario);
	
	void deleteAccount(Integer id);


}
