package com.tantalean.pedido.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tantalean.pedido.entity.Cliente;
import com.tantalean.pedido.repository.ClienteRepository;
import com.tantalean.pedido.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByRazonSocialContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Cliente create(Cliente cliente) {
        cliente.setId(null);
        return repository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente update(Long id, Cliente cliente) {

        Cliente updated = findById(id);

        updated.setRazonSocial(cliente.getRazonSocial());
        updated.setDocumento(cliente.getDocumento());
        updated.setDireccion(cliente.getDireccion());
        updated.setTelefono(cliente.getTelefono());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
