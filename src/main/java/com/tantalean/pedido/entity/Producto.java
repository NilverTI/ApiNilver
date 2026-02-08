package com.tantalean.pedido.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String Codigo;
    @Column(name = "precio_unitario", precision = 8, scale = 2, nullable = false)
    private BigDecimal precioUnitario;
}
