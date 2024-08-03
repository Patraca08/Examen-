package com.pruebaSpringBoot.controller;

import com.pruebaSpringBoot.model.Cuenta;
import com.pruebaSpringBoot.service.CuentaService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) {
	super();
	this.service = service;
}

	@GetMapping
    public List<Cuenta> obtenerCuentas() {
        return service.getAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerPorId(@PathVariable Integer id) {
        Optional<Cuenta> cuenta = service.getAccountById(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta crearCuenta(@Validated @RequestBody Cuenta cuenta) {
        return service.createAccount(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Integer id, @Validated @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> cuenta = service.updateAccount(id, cuentaDetails);
        if (cuenta.isPresent()) {
            return ResponseEntity.ok(cuenta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Integer id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
