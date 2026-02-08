package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DetallePedidoService {
    Page<DetallePedido> findAll(Pageable pageable);
    DetallePedido findById(Long id);
    DetallePedido create(DetallePedido detalle);
    DetallePedido update(Long id, DetallePedido detalle);
    void deleteById(Long id);
}
