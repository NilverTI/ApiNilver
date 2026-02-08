package com.tantalean.pedido.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tantalean.pedido.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findByRazonSocialContainingIgnoreCase(String razonSocial, Pageable pageable);

}
