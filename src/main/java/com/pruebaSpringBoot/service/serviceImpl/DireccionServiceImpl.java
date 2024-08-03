package com.pruebaSpringBoot.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pruebaSpringBoot.model.Direccion;
import com.pruebaSpringBoot.repository.DireccionRepository;
import com.pruebaSpringBoot.service.DireccionService;

@Component
public class DireccionServiceImpl implements DireccionService{
	
	private final DireccionRepository repository;
	
	public DireccionServiceImpl(DireccionRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Direccion> getAccounts() {
		return repository.findAll();
	}

	@Override
	public Optional<Direccion> getAccountById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Direccion createAccount(Direccion direccion) {
		return repository.save(direccion);
	}

	@Override
	public Optional<Direccion> updateAccount(Integer id, Direccion direccion) {
		Optional<Direccion> direccioObj = repository.findById(id);
		
		if(direccioObj.isPresent()) {
			Direccion newDireccion = direccioObj.get();
			newDireccion.setCodigoPostal(direccion.getCodigoPostal());
			newDireccion.setEstado(direccion.getEstado());
			repository.save(newDireccion);
			Optional<Direccion> result = Optional.of(newDireccion);
			return result;
		} else {
			return Optional.empty();
		}

	}

	@Override
	public void deleteAccount(Integer id) {
		
		repository.deleteById(id);
		
	}

}
