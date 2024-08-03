package com.pruebaSpringBoot.controller;

import com.pruebaSpringBoot.model.Usuario;
import com.pruebaSpringBoot.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    
    public UsuarioController(UsuarioService service) {
		super();
		this.service = service;
	}

	@GetMapping
    public List<Usuario> obetenerUsuarios() {
        return service.getAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = service.getAccountById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario crearUsuario(@Validated @RequestBody Usuario usuario) {
        return service.createAccount(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @Validated @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> usuario = service.updateAccount(id, usuarioDetails);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
            service.deleteAccount(id);
            return ResponseEntity.noContent().build();
        }
    }
