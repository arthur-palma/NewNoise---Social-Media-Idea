package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.domain.Amizade;
import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.mapper.AmizadeMapper;
import br.com.cwi.newnoise.repository.AmizadeRepository;
import br.com.cwi.newnoise.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

import static br.com.cwi.newnoise.mapper.SolicitacaoAmizadeMapper.toEntity;

@Service
public class AceitarAmizadeService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private ValidaExisteSolicitacaoPendenteService validaExisteSolicitacaoPendenteService;

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private AmizadeRepository amizadeRepository;

    public void aceitarAmizade(Long idUsuario, Long idUsuarioSolicitante) {
        Usuario usuario = validaUsuarioExisteService.validaPorId(idUsuario);
        Usuario usuarioSolicitado = validaUsuarioExisteService.validaPorId(idUsuarioSolicitante);

        SolicitacaoAmizade solicitacaoAmizade = validaExisteSolicitacaoPendenteService.validaSolicitado(usuario,usuarioSolicitado);

        Amizade amizade = AmizadeMapper.toEntity(solicitacaoAmizade);

        usuario.adicionarAmigoUsuario(amizade);
        usuarioSolicitado.adicionarAmigo(amizade);

        amizadeRepository.save(amizade);
        solicitacaoAmizadeRepository.delete(solicitacaoAmizade);
    }
}


