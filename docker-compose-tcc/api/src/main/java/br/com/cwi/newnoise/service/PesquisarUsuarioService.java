package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;
import br.com.cwi.newnoise.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PesquisarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    public List<UsuarioResponse> pesquisarUsuario(Long id, String text, Pageable pageable) {

        return usuarioRepository.findNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(id,text,pageable).stream()
                .map(UsuarioMapper::toResponse)
                .collect(toList());
    }

    public List<UsuarioResponse> pesquisarAmigo(Long id, String text) {
        return usuarioRepository.findAmigosByNomeOrEmailAndUsuarioId(text,text,id).stream()
                .map(UsuarioMapper::toResponse)
                .collect(toList());
    }
}
