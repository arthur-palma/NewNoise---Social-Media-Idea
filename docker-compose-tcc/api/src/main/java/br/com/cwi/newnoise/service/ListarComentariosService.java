package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.controller.response.ComentarioResponse;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.mapper.ComentarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarComentariosService {

    @Autowired
    private ValidaPostagemExisteService validaPostagemExisteService;

    public List<ComentarioResponse> listar(Long idPostagem) {
        Postagem postagem = validaPostagemExisteService.validarPorId(idPostagem);

        return postagem.getComentarios().stream()
                .map(ComentarioMapper::toResponse)
                .collect(Collectors.toList());
    }
}
