package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.domain.Amizade;
import br.com.cwi.newnoise.domain.SolicitacaoAmizade;

public class AmizadeMapper {


    public static Amizade toEntity(SolicitacaoAmizade solicitacaoAmizade) {
        return Amizade.builder()
                .usuario(solicitacaoAmizade.getSolicitante())
                .amigo(solicitacaoAmizade.getSolicitado())
                .build();
    }
}
