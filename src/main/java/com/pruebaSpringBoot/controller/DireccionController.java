package com.pruebaSpringBoot.controller;

import com.pruebaSpringBoot.model.Direccion;
import com.pruebaSpringBoot.service.DireccionService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    
    private final DireccionService service;

    public DireccionController(DireccionService service) {
		super();
		this.service = service;
	}

	@GetMapping
    public List<Direccion> obtenerDirecciones() {
        return service.getAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> obtenerPorId(@PathVariable Integer id) {
        Optional<Direccion> direccion = service.getAccountById(id);
        return direccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Direccion crearDireccion(@Validated @RequestBody Direccion direccion) {
        return service.createAccount(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Integer id, @Validated @RequestBody Direccion direccionDetails) {
        Optional<Direccion> direccion = service.updateAccount(id, direccionDetails);
        if (direccion.isPresent()) {
            return ResponseEntity.ok(direccion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Integer id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
