package com.tantalean.pedido.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tantalean.pedido.entity.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    Page<Trabajador> findByNombresContainingIgnoreCase(String nombres, Pageable pageable);
}
