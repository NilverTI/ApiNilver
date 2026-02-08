package com.tantalean.pedido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String cargo;
}
