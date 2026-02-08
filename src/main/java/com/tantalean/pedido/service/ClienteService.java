package com.tantalean.pedido.service;

import com.tantalean.pedido.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    Page<Cliente> findAll(Pageable pageable);
    Page<Cliente> search(String razonSocial, Pageable pageable);
    Cliente findById(Long id);
    Cliente create(Cliente cliente);
    Cliente update(Long id, Cliente cliente);
    void deleteById(Long id);

}
