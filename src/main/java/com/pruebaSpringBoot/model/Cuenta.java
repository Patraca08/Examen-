package com.pruebaSpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(1000000000L)
    @Max(9999999999L)
    private Long numeroCuenta;

    @NotNull
    @DecimalMin("0.1")
    private Float ingresos;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Cuenta() {
    }

    public Cuenta(Integer id, Long numeroCuenta, Float ingresos, Usuario usuario) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.ingresos = ingresos;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @Min(1000000000L) @Max(9999999999L) Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(@NotNull @Min(1000000000L) @Max(9999999999L) Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public @NotNull @DecimalMin("0.1") Float getIngresos() {
        return ingresos;
    }

    public void setIngresos(@NotNull @DecimalMin("0.1") Float ingresos) {
        this.ingresos = ingresos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
