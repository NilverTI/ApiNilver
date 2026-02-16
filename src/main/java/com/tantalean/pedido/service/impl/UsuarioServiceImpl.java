package com.tantalean.pedido.service.impl;

import com.tantalean.pedido.entity.Usuario;
import com.tantalean.pedido.repository.UsuarioRepository;
import com.tantalean.pedido.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable);
        }
        return repository.findByUsernameContainingIgnoreCase(texto, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setId(null);
        return repository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario existente = findById(id);

        existente.setUsername(usuario.getUsername());
        existente.setEmail(usuario.getEmail());
        existente.setPassword(usuario.getPassword());
        existente.setActivo(usuario.isActivo());
        existente.setRoles(usuario.getRoles());

        return repository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
