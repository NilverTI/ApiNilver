package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    Page<Producto> findAll (Pageable pageable);
    Page<Producto> search (String nombre, Pageable pageable);
    Producto findById (Long id);
    Producto create (Producto producto);
    Producto update (Long id, Producto producto);
    void deleteById (Long id);
} 