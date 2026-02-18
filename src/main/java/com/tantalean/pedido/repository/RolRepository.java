package com.tantalean.pedido.repository;

import com.tantalean.pedido.entity.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Page<Rol> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}