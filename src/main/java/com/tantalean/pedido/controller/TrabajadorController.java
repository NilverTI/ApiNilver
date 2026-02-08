package com.tantalean.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tantalean.pedido.entity.Trabajador;
import com.tantalean.pedido.service.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService service;

    @GetMapping
    public Page<Trabajador> getAll(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
    ) {
        return service.search(search, pageable);
    }

    @GetMapping("/{id}")
    public Trabajador getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Trabajador> create(@RequestBody Trabajador trabajador) {
        Trabajador created = service.create(trabajador);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> update(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(service.update(id, trabajador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
