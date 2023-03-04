package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.controller.request.PostagemRequest;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.mapper.PostagemMapper;
import br.com.cwi.newnoise.repository.PostagemRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PublicarPostagemService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private PostagemRepository postagemRepository;

    public void publicar(Long id, PostagemRequest request) {
        Usuario usuario = validaUsuarioExisteService.validaPorId(id);
        Postagem postagem = PostagemMapper.toEntity(request);

        postagem.setDataPostagem(LocalDateTime.now());
        usuario.adicionarPostagem(postagem);

        postagemRepository.save(postagem);
    }
}
