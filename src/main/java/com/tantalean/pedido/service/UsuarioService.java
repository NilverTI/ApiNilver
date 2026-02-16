package com.tantalean.pedido.service;

import com.tantalean.pedido.dto.UsuarioResponseDTO;
import com.tantalean.pedido.entity.Usuario;

import org.springframework.data.domain.*;

public interface UsuarioService {
    Page<UsuarioResponseDTO> findAll (Pageable pageable);
    Page<UsuarioResponseDTO> search (String texto, Pageable pageable);
    UsuarioResponseDTO findById (Long id);
    UsuarioResponseDTO create (Usuario usuario);
    UsuarioResponseDTO update (Long id, Usuario usuario);
    void deleteById (Long id);
} 