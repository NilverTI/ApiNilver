package com.tantalean.pedido.service.impl;

import com.tantalean.pedido.dto.UsuarioResponseDTO;
import com.tantalean.pedido.entity.Usuario;
import com.tantalean.pedido.mapper.UsuarioMapper;
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

    @Autowired
    private UsuarioMapper mapper; // ✅ era rolRepository (mal)

    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> search(String texto, Pageable pageable) {
        if (texto == null || texto.isBlank()) {
            return repository.findAll(pageable).map(mapper::toDTO);
        }
        return repository.findByUsernameContainingIgnoreCase(texto, pageable)
                .map(mapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO findById(Long id) {
        Usuario entity = repository.findById(id).orElseThrow();
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(Usuario usuario) {
        usuario.setId(null);
        Usuario saved = repository.save(usuario);
        return mapper.toDTO(saved);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, Usuario usuario) {
        Usuario existente = repository.findById(id).orElseThrow();

        existente.setUsername(usuario.getUsername());
        existente.setEmail(usuario.getEmail());
        existente.setPassword(usuario.getPassword());
        existente.setActivo(usuario.isActivo());
        existente.setRoles(usuario.getRoles());

        Usuario saved = repository.save(existente);
        return mapper.toDTO(saved);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
