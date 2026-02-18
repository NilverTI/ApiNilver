package com.tantalean.pedido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social", length=100)
    private String razonSocial;

    @Column(name = "direccion", length=100, nullable = true)
    private String direccion;
}
