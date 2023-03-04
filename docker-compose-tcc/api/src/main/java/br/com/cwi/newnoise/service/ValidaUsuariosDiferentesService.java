package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaUsuariosDiferentesService {

    public void validar(Usuario usuario, Usuario usuarioSolicitado) {
        if(usuario.equals(usuarioSolicitado))
            throw new ResponseStatusException(BAD_REQUEST,"Não é possivel fazer uma solicitacao de amizade para si mesmo!");
    }
}
