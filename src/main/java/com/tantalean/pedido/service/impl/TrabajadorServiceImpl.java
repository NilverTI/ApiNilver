package com.tantalean.pedido.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.Trabajador;
import com.tantalean.pedido.repository.TrabajadorRepository;
import com.tantalean.pedido.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Trabajador> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Trabajador> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByNombresContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Trabajador findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Trabajador create(Trabajador trabajador) {
        trabajador.setId(null);
        return repository.save(trabajador);
    }

    @Override
    @Transactional
    public Trabajador update(Long id, Trabajador trabajador) {
        Trabajador updated = findById(id);

        updated.setDni(trabajador.getDni());
        updated.setNombres(trabajador.getNombres());
        updated.setApellidos(trabajador.getApellidos());
        updated.setTelefono(trabajador.getTelefono());
        updated.setCargo(trabajador.getCargo());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
