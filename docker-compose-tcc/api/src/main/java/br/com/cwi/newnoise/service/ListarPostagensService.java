package br.com.cwi.newnoise.service;

import br.com.cwi.newnoise.controller.response.PostagemResponse;
import br.com.cwi.newnoise.mapper.PostagemMapper;
import br.com.cwi.newnoise.repository.AmizadeRepository;
import br.com.cwi.newnoise.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.cwi.newnoise.domain.TipoVisibilidade.PUBLICO;

@Service
public class ListarPostagensService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    public Page<PostagemResponse> listarTodas(Long id, Pageable pageable) {
        validaUsuarioExisteService.validaPorId(id);

        return postagemRepository.findAllByUsuarioOrAmigos(id, pageable)
                .map(PostagemMapper::toResponse);
    }

    public Page<PostagemResponse> listarPerfil(Long idUsuario, Long idUsuarioPerfil, Pageable pageable) {
        boolean isAmigo = amizadeRepository.findByUsuarioIdAndAmigoId(idUsuario, idUsuarioPerfil).isPresent();
        validaUsuarioExisteService.validaPorId(idUsuario);
        validaUsuarioExisteService.validaPorId(idUsuarioPerfil);

        if(isAmigo){
            return postagemRepository.findByUsuarioIdOrderByDataPostagemDesc(idUsuarioPerfil,pageable)
                    .map(PostagemMapper::toResponse);
        }

        return postagemRepository.findByUsuarioIdAndVisibilidadeOrderByDataPostagemDesc(idUsuarioPerfil, PUBLICO, pageable)
                .map(PostagemMapper::toResponse);
    }
}
