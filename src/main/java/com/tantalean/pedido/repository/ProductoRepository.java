package com.tantalean.pedido.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tantalean.pedido.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

}