package com.tantalean.pedido.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false, length = 20)
    private String username;
    @Column (unique = true, nullable = false, length = 70)
    private String email;
    @Column (nullable = false, length = 128)
    private String password;
    private boolean activo;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )   
    private Set<Rol> roles = new HashSet<>();
}
