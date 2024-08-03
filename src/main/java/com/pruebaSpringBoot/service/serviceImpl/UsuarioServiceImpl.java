package com.pruebaSpringBoot.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pruebaSpringBoot.model.Usuario;
import com.pruebaSpringBoot.repository.UsuarioRepository;
import com.pruebaSpringBoot.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UsuarioService{

	private final UsuarioRepository repository;
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Usuario> getAccounts() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> getAccountById(Integer id) {
		
		Optional<Usuario> result = repository.findById(id);
		
		return result;
	}

	@Override
	public Usuario createAccount(Usuario usuario) {
		
		Usuario result = repository.save(usuario);
		
		return result;
	}

	@Override
	public Optional<Usuario> updateAccount(Integer id, Usuario usuario) {
		
		Optional<Usuario> userObj = repository.findById(id);
		
		if(userObj.isPresent()) {
		   Usuario newUser = userObj.get();
		   newUser.setNombre(usuario.getNombre());
		   newUser.setApellidoMaterno(usuario.getApellidoMaterno());
		   newUser.setApellidoPaterno(usuario.getApellidoPaterno());
		   newUser.setFechaNacimiento(usuario.getFechaNacimiento());
		   Usuario user = repository.save(newUser);
		   Optional<Usuario> response = Optional.of(user);
		   return response;
		   
		} else {
			return Optional.empty();
		}
		
	}

	@Override
	public void deleteAccount(Integer id) {
		
		repository.deleteById(id);
		
	}

}
