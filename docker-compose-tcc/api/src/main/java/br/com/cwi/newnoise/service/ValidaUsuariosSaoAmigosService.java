package br.com.cwi.newnoise.service;

import br.com.cwi.newnoise.domain.Amizade;
import br.com.cwi.newnoise.repository.AmizadeRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaUsuariosSaoAmigosService {

    @Autowired
    private AmizadeRepository amizadeRepository;


    public void validar(Usuario usuario, Usuario usuarioSolicitado) {
        Optional<Amizade> amizade = amizadeRepository.findByUsuarioIdAndAmigoId(usuario.getId(),usuarioSolicitado.getId());

        if(amizade.isPresent()){
            throw new ResponseStatusException(BAD_REQUEST,"Usuarios já são amigos");
        }
    }

    public void validarNaoSaoAmigos(Usuario usuario, Usuario usuarioSolicitado) {
        Optional<Amizade> amizade = amizadeRepository.findByUsuarioIdAndAmigoId(usuario.getId(),usuarioSolicitado.getId());

        if(amizade.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST,"Usuarios não sao amigos");
        }
    }
}
