package com.tantalean.pedido.service.impl;

import com.tantalean.pedido.service.ProductoService;
import com.tantalean.pedido.entity.Producto;
import com.tantalean.pedido.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByNombreContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Producto create(Producto producto) {
        producto.setId(null);
        return repository.save(producto);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto producto) {
        Producto existente=findById(id);
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setCodigo(producto.getCodigo());
        existente.setPrecioUnitario(producto.getPrecioUnitario());
        return repository.save(existente);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}