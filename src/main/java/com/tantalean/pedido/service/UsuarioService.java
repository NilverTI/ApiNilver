package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    Page<Usuario> findAll (Pageable pageable);
    Page<Usuario> search (String texto, Pageable pageable);
    Usuario findById (Long id);
    Usuario create (Usuario usuario);
    Usuario update (Long id, Usuario usuario);
    void deleteById (Long id);
} 