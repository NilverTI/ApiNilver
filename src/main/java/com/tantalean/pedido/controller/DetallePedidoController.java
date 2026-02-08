package com.tantalean.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tantalean.pedido.entity.DetallePedido;
import com.tantalean.pedido.service.DetallePedidoService;

@RestController
@RequestMapping("/api/detalle-pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService service;

    @GetMapping
    public Page<DetallePedido> getAll(
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
    ) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public DetallePedido getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DetallePedido> create(@RequestBody DetallePedido detalle) {
        DetallePedido created = service.create(detalle);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> update(@PathVariable Long id, @RequestBody DetallePedido detalle) {
        return ResponseEntity.ok(service.update(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
