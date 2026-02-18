package com.tantalean.pedido.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String username;
    private String email;
    private boolean activo;
    private Set<String> roles;
}