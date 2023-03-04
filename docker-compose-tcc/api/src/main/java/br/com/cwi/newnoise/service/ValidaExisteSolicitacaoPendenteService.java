package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaExisteSolicitacaoPendenteService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;


    public void validar(Usuario usuario, Usuario usuarioSolicitado) throws ResponseStatusException {
        Optional<SolicitacaoAmizade> solicitacaoAmizadeOptional = solicitacaoAmizadeRepository.findBySolicitanteAndSolicitadoOrSolicitadoAndSolicitante(usuario, usuarioSolicitado, "PENDENTE");

        if (solicitacaoAmizadeOptional.isPresent()) {
            throw new ResponseStatusException(BAD_REQUEST,"Já existe uma solicitação de amizade pendente entre esses dois usuários");
        }
    }

    public SolicitacaoAmizade validaSolicitado(Usuario usuario, Usuario usuarioSolicitante) {
       return solicitacaoAmizadeRepository.findBySolicitanteAndSolicitado( usuarioSolicitante, usuario)
               .orElseThrow(()-> new ResponseStatusException(BAD_REQUEST,"Não existe nenhuma soliciatacao pendente que atenda aos requisitos"));
    }
}
