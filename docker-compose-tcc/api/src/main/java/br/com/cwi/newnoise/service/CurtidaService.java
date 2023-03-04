package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.domain.Curtida;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.repository.CurtidaRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurtidaService {

    @Autowired
    ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    ValidaPostagemExisteService validaPostagemExisteService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    public void curtir(Long usuarioId, Long postagemId) {

        Usuario usuario = validaUsuarioExisteService.validaPorId(usuarioId);
        Postagem postagem = validaPostagemExisteService.validarPorId(postagemId);

        Curtida curtida = Curtida.builder()
                .usuario(usuario)
                .postagem(postagem)
                .build();
        curtidaRepository.save(curtida);
    }

    public void descurtir(Long usuarioId, Long postagemId) {
        Usuario usuario = validaUsuarioExisteService.validaPorId(usuarioId);
        Postagem postagem = validaPostagemExisteService.validarPorId(postagemId);

        Optional<Curtida> curtidaOptional = curtidaRepository.findByUsuarioAndPostagem(usuario, postagem);

        if (curtidaOptional.isPresent()) {
            Curtida curtida = curtidaOptional.get();
            curtidaRepository.delete(curtida);
        }
    }


}
