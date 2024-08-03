package com.pruebaSpringBoot.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pruebaSpringBoot.model.Cuenta;
import com.pruebaSpringBoot.repository.CuentaRepository;
import com.pruebaSpringBoot.service.CuentaService;

@Component
public class CuentaServiceImpl implements CuentaService{
	
	private final CuentaRepository repository;

	public CuentaServiceImpl(CuentaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Cuenta> getAccounts() {
		
		List<Cuenta> result = repository.findAll();
		
		return result;
	}

	@Override
	public Optional<Cuenta> getAccountById(Integer id) {
		
		Optional<Cuenta> cuenta = repository.findById(id);
		
		return cuenta;
	}

	@Override
	public Cuenta createAccount(Cuenta cuenta) {
		
		Cuenta result = repository.save(cuenta);
		
		return result;
	}

	@Override
	public Optional<Cuenta> updateAccount(Integer id, Cuenta cuenta) {
		
		Optional<Cuenta> cuentaObject = repository.findById(id);
		
		if(cuentaObject.isPresent()) {
			Cuenta newAccount = cuentaObject.get();
			newAccount.setNumeroCuenta(cuenta.getNumeroCuenta());
			newAccount.setIngresos(cuenta.getIngresos());
			Optional<Cuenta> result = Optional.of(newAccount);
			repository.save(newAccount);
			return result;
	    } else {
	    	Optional<Cuenta> notExist = Optional.empty();
	    	return notExist;
	    }
	    	
	}

	@Override
	public void deleteAccount(Integer id) {
		
		repository.deleteById(id);
		
	}
	
	

}
