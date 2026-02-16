package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolService {
    Page<Rol> findAll(Pageable pageable);
    Page<Rol> search(String texto, Pageable pageable);
    Rol findById(Long id);
    Rol create(Rol rol);
    Rol update(Long id, Rol rol);
    void deleteById(Long id);
}
