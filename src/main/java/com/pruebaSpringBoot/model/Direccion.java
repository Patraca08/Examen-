package com.pruebaSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 6, max = 6)
    private String codigoPostal;

    @NotBlank
    private String estado;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(Integer id, String codigoPostal, String estado, Usuario usuario) {
        this.id = id;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 6, max = 6) String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(@NotBlank @Size(min = 6, max = 6) String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public @NotBlank String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
