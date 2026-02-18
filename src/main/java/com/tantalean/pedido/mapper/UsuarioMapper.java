package com.tantalean.pedido.mapper;

import com.tantalean.pedido.dto.UsuarioResponseDTO;
import com.tantalean.pedido.entity.Rol;
import com.tantalean.pedido.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDTO(Usuario entity){
        Set<String> roles = entity.getRoles()
                .stream()
                .map(Rol::getNombre)
                .collect(Collectors.toSet());

        return new UsuarioResponseDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.isActivo(),
                roles
        );
    }

    public Usuario toEntity(UsuarioResponseDTO dto){
        return null;
    }
}