package br.com.cwi.newnoise.service;

import br.com.cwi.newnoise.security.domain.Usuario;
import br.com.cwi.newnoise.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaUsuarioExisteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validaPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"Usuario com id "+ id +" não encontrado"));
    }
}
