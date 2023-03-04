package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.newnoise.mapper.SolicitacaoAmizadeMapper.toEntity;

@Service
public class SolicitacarAmizadeService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private ValidaExisteSolicitacaoPendenteService validaExisteSolicitacaoPendenteService;

    @Autowired
    private ValidaUsuariosSaoAmigosService validaUsuariosSaoAmigosService;

    @Autowired
    private ValidaUsuariosDiferentesService validaUsuariosDiferentesService;


    public void solicitarAmizade(Long idUsuario, Long idUsuarioSolicitado) {
        Usuario usuario = validaUsuarioExisteService.validaPorId(idUsuario);
        Usuario usuarioSolicitado = validaUsuarioExisteService.validaPorId(idUsuarioSolicitado);

        validaUsuariosDiferentesService.validar(usuario,usuarioSolicitado);

        validaUsuariosSaoAmigosService.validar(usuario,usuarioSolicitado);

        validaExisteSolicitacaoPendenteService.validar(usuario,usuarioSolicitado);

        SolicitacaoAmizade solicitacaoAmizade = toEntity(usuario,usuarioSolicitado);
        solicitacaoAmizade.setStatus("PENDENTE");

        solicitacaoAmizadeRepository.save(solicitacaoAmizade);
    }

}
