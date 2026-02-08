package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrabajadorService {
    Page<Trabajador> findAll(Pageable pageable);
    Page<Trabajador> search(String texto, Pageable pageable);
    Trabajador findById(Long id);
    Trabajador create(Trabajador trabajador);
    Trabajador update(Long id, Trabajador trabajador);
    void deleteById(Long id);
}
