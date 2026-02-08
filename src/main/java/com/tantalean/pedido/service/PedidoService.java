package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService {
    Page<Pedido> findAll(Pageable pageable);
    Page<Pedido> search(String texto, Pageable pageable);
    Pedido findById(Long id);
    Pedido create(Pedido pedido);
    Pedido update(Long id, Pedido pedido);
    void deleteById(Long id);
}
