package com.tantalean.pedido.controller;

import com.tantalean.pedido.entity.Rol;
import com.tantalean.pedido.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @Autowired
    private RolService service;

    // GET /roles?page=0&size=10&sort=nombre,asc
    @GetMapping
    public Page<Rol> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    // GET /roles/search?texto=adm&page=0&size=10
    @GetMapping("/search")
    public Page<Rol> search(@RequestParam(required = false) String texto, Pageable pageable) {
        return service.search(texto, pageable);
    }

    // GET /roles/1
    @GetMapping("/{id}")
    public Rol findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /roles
    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return service.create(rol);
    }

    // PUT /roles/1
    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol rol) {
        return service.update(id, rol);
    }

    // DELETE /roles/1
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
