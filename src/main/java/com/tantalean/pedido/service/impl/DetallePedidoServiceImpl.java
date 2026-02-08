package com.tantalean.pedido.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.DetallePedido;
import com.tantalean.pedido.repository.DetallePedidoRepository;
import com.tantalean.pedido.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<DetallePedido> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedido findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public DetallePedido create(DetallePedido detalle) {
        detalle.setId(null);
        return repository.save(detalle);
    }

    @Override
    @Transactional
    public DetallePedido update(Long id, DetallePedido detalle) {
        DetallePedido updated = findById(id);

        updated.setCantidad(detalle.getCantidad());
        updated.setPrecioUnitario(detalle.getPrecioUnitario());
        updated.setSubtotal(detalle.getSubtotal());
        updated.setPedido(detalle.getPedido());
        updated.setProducto(detalle.getProducto());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
