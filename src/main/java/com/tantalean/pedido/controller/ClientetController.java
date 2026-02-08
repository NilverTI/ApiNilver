package com.tantalean.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tantalean.pedido.entity.Cliente;
import com.tantalean.pedido.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClientetController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public Page<Cliente> getAll(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable
    ) {
        return service.search(search, pageable);
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente created = service.create(cliente);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(
            @PathVariable Long id,
            @RequestBody Cliente cliente
    ) {
        return ResponseEntity.ok(service.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
