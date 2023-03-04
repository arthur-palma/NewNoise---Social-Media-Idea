package br.com.cwi.newnoise.service;


import br.com.cwi.newnoise.repository.AmizadeRepository;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesfazerAmizadeService {

    @Autowired
    private ValidaUsuarioExisteService validaUsuarioExisteService;

    @Autowired
    private ValidaUsuariosDiferentesService validaUsuariosDiferentesService;

    @Autowired
    private ValidaUsuariosSaoAmigosService validaUsuariosSaoAmigosService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    public void desfazerAmizade(Long idUsuario, Long idAmigo) {
       Usuario usuario = validaUsuarioExisteService.validaPorId(idUsuario);
       Usuario amigo = validaUsuarioExisteService.validaPorId(idAmigo);

       validaUsuariosDiferentesService.validar(usuario,amigo);
       validaUsuariosSaoAmigosService.validarNaoSaoAmigos(usuario,amigo);

       amizadeRepository.delete(amizadeRepository.findByUsuarioIdAndAmigoId(idUsuario,idAmigo).get());
    }
}
