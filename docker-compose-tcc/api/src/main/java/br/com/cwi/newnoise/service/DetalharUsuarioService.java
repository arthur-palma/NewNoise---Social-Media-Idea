package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.newnoise.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.domain.Usuario;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;
import br.com.cwi.newnoise.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalharUsuarioService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDetalhadoResponse detalhar(Long id) {

        List<UsuarioResponse> amigos = usuarioRepository.findAllAmigosByIdUsuario(id)
                .stream().map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
        Usuario usuario = validaUsuarioExisteService.validaPorId(id);
                UsuarioDetalhadoResponse usuarioDetalhado = UsuarioDetalhadoMapper.toResponse(usuario);
                usuarioDetalhado.setAmigos(amigos);
                return usuarioDetalhado;
    }
}
