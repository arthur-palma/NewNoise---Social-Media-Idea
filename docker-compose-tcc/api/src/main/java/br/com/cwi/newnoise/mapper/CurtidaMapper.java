package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.controller.response.CurtidaResponse;
import br.com.cwi.newnoise.domain.Curtida;

public class CurtidaMapper {

    public static CurtidaResponse toResponse(Curtida curtida){
            return CurtidaResponse.builder()
                    .id(curtida.getId())
                    .postagemId(curtida.getPostagem().getId())
                    .usuarioId(curtida.getUsuario().getId())
                    .build();
    }
}
