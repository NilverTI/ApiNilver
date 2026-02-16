package com.tantalean.pedido.controller;

import com.tantalean.pedido.dto.UsuarioResponseDTO;
import com.tantalean.pedido.entity.Usuario;
import com.tantalean.pedido.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public Page<UsuarioResponseDTO> getAll(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        return service.search(search, pageable);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody Usuario usuario) {
        UsuarioResponseDTO created = service.create(usuario);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.update(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
