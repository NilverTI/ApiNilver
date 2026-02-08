package com.tantalean.pedido.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.Pedido;
import com.tantalean.pedido.repository.PedidoRepository;
import com.tantalean.pedido.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Pedido> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pedido> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByEstadoContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Pedido create(Pedido pedido) {
        pedido.setId(null);
        if (pedido.getFechaHora() == null) {
            pedido.setFechaHora(LocalDateTime.now());
        }
        return repository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido update(Long id, Pedido pedido) {
        Pedido updated = findById(id);

        updated.setFechaHora(pedido.getFechaHora());
        updated.setEstado(pedido.getEstado());
        updated.setTotal(pedido.getTotal());
        updated.setCliente(pedido.getCliente());
        updated.setTrabajador(pedido.getTrabajador());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
