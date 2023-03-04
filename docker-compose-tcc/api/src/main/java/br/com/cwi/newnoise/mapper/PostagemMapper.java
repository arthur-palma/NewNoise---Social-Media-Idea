package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.controller.request.PostagemRequest;
import br.com.cwi.newnoise.controller.response.ComentarioResponse;
import br.com.cwi.newnoise.controller.response.PostagemResponse;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PostagemMapper {
    public static Postagem toEntity(PostagemRequest request) {
        return Postagem.builder()
                .texto(request.getConteudo())
                .visibilidade(request.getTipoVisibilidade())
                .build();
    }

    public static PostagemResponse toResponse(Postagem postagem) {

        return PostagemResponse.builder()
                .id(postagem.getId())
                .usuario(UsuarioMapper.toResponse(postagem.getUsuario()))
                .texto(postagem.getTexto())
                .visibilidade(postagem.getVisibilidade())
                .dataPostagem(postagem.getDataPostagem())
                .comentarios(postagem.getComentarios().stream().map(ComentarioMapper::toResponse).collect(toList()))
                .curtidas(postagem.getCurtidas().stream().map(CurtidaMapper::toResponse).collect(toList()))
                .totalCurtidas(postagem.getCurtidas().size())
                .totalComentarios(postagem.getComentarios().size())
                .build();
    }
}
