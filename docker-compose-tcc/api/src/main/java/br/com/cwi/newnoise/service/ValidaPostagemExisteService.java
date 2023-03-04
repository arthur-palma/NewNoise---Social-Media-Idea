package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaPostagemExisteService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem validarPorId(Long postagemId) {
        return postagemRepository.findById(postagemId)
                .orElseThrow(()-> new ResponseStatusException(BAD_REQUEST,"Não existe postagem com id "+postagemId));
    }
}
