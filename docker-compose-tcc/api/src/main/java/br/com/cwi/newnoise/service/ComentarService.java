package br.com.cwi.newnoise.service;

import br.com.cwi.newnoise.controller.request.ComentarioRequest;
import br.com.cwi.newnoise.domain.Comentario;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.mapper.ComentarioMapper;
import br.com.cwi.newnoise.repository.ComentarioRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class ComentarService {

    @Autowired
    private ValidaPostagemExisteService validaPostagemExisteService;

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public void comentar(ComentarioRequest request) {

        Postagem postagem =validaPostagemExisteService.validarPorId(request.getPostagemId());
        Usuario usuario = validaUsuarioExisteService.validaPorId(request.getUsuarioId());

        Comentario comentario = ComentarioMapper.toEntity(request);
        comentario.setDataComentario(LocalDateTime.now());
        comentario.setUsuario(usuario);
        comentario.setPostagem(postagem);

        comentarioRepository.save(comentario);
    }
}
