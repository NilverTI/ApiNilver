package com.tantalean.pedido.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String codigo;
    @Column(name = "precio_unitario", precision = 8, scale = 2, nullable = false)
    private BigDecimal precioUnitario;
}
