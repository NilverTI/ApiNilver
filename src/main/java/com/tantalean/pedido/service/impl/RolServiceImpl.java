package com.tantalean.pedido.service.impl;

import com.tantalean.pedido.entity.Rol;
import com.tantalean.pedido.repository.RolRepository;
import com.tantalean.pedido.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Rol> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Rol> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByNombreContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Rol create(Rol rol) {
        rol.setId(null);
        return repository.save(rol);
    }

    @Override
    @Transactional
    public Rol update(Long id, Rol rol) {
        Rol existente = findById(id);
        existente.setNombre(rol.getNombre());
        existente.setDescripcion(rol.getDescripcion());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
