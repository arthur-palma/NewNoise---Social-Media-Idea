package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.security.domain.Usuario;
import br.com.cwi.newnoise.security.mapper.UsuarioMapper;

public class SolicitacaoAmizadeMapper {
    public static SolicitacaoAmizadeResponse toResponse(SolicitacaoAmizade solicitacaoAmizade) {
        return SolicitacaoAmizadeResponse.builder()
                .id(solicitacaoAmizade.getId())
                .solicitante(UsuarioMapper.toResponse(solicitacaoAmizade.getSolicitante()))
                .status(solicitacaoAmizade.getStatus())
                .build();
    }


    public static SolicitacaoAmizade toEntity(Usuario usuario, Usuario usuarioSolicitado) {
       return SolicitacaoAmizade.builder()
                .solicitante(usuario)
                .solicitado(usuarioSolicitado)
                .build();

    }
}
