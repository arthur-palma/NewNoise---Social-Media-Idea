package br.com.cwi.newnoise.service;

import br.com.cwi.newnoise.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.mapper.SolicitacaoAmizadeMapper;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarSolicitacoesService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    public List<SolicitacaoAmizadeResponse> listar(Long id) {
        Usuario usuario = validaUsuarioExisteService.validaPorId(id);

        List<SolicitacaoAmizade> solicitacoes = usuario.getSolicitacoesRecebidas();

        return solicitacoes.stream()
                .map(SolicitacaoAmizadeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
