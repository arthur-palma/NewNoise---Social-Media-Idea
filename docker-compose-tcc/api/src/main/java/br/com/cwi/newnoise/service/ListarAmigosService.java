package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;
import br.com.cwi.newnoise.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmigosService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<UsuarioResponse> listar(Long id) {

        validaUsuarioExisteService.validaPorId(id);

        return usuarioRepository.findAllAmigosByIdUsuario(id)
                .stream().map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
    }
}
