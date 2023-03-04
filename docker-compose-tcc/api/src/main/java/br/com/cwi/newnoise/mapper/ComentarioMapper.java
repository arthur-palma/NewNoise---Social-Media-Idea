package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.controller.request.ComentarioRequest;
import br.com.cwi.newnoise.controller.response.ComentarioResponse;
import br.com.cwi.newnoise.domain.Comentario;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;

public class ComentarioMapper {
    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .id(comentario.getId())
                .texto(comentario.getTexto())
                .dataComentario(comentario.getDataComentario())
                .usuario(UsuarioMapper.toResponse(comentario.getUsuario()))
                .build();
        }

    public static Comentario toEntity(ComentarioRequest request) {
        return Comentario.builder()
                .texto(request.getTexto())
                .build();
    }
}
