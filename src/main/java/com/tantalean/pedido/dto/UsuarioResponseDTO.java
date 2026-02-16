package com.tantalean.pedido.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String activo;
    private Set<String> roles;
}
