package br.com.cwi.newnoise.controller;

import br.com.cwi.newnoise.controller.request.ComentarioRequest;
import br.com.cwi.newnoise.controller.request.PostagemRequest;
import br.com.cwi.newnoise.controller.response.ComentarioResponse;
import br.com.cwi.newnoise.controller.response.PostagemResponse;
import br.com.cwi.newnoise.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.newnoise.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private ListarSolicitacoesService listarSolicitacoesService;

    @Autowired
    private PublicarPostagemService publicarPostagemService;

    @Autowired
    private ListarPostagensService listarPostagensService;

    @Autowired
    private PesquisarUsuarioService pesquisarUsuarioService;

    @Autowired
    private ComentarService comentarService;

    @Autowired
    private CurtidaService curtidaService;

    @Autowired
    private SolicitacarAmizadeService solicitacarAmizadeService;

    @Autowired
    private AceitarAmizadeService aceitarAmizadeService;

    @Autowired
    private DesfazerAmizadeService desfazerAmizadeService;

    @Autowired
    private ListarAmigosService listarAmigosService;


    @Autowired
    private ListarComentariosService listarComentariosService;


    @GetMapping("/detalhar/{id}")
    public UsuarioDetalhadoResponse detalhar(@PathVariable Long id){
        return detalharUsuarioService.detalhar(id);
    }

    @GetMapping("/listarSolicitacoes/{id}")
    public List<SolicitacaoAmizadeResponse> listarSolicitacoes(@PathVariable Long id){
        return listarSolicitacoesService.listar(id);
    }

    @PostMapping("/publicarPostagem/{id}")
    public void publicarPostagem(@PathVariable Long id, @Valid @RequestBody PostagemRequest request){
        publicarPostagemService.publicar(id,request);
    }

    @GetMapping("/listarTodasPostagens/{id}")
    public Page<PostagemResponse> listarTodasPostagens(@PathVariable Long id, Pageable pageable){
        return listarPostagensService.listarTodas(id,pageable);
    }

    @GetMapping("/{idUsuario}/acessarPerfil/{idUsuarioPerfil}")
    public Page<PostagemResponse> listarPostagens(@PathVariable Long idUsuario, @PathVariable Long idUsuarioPerfil, Pageable pageable){
        return listarPostagensService.listarPerfil(idUsuario,idUsuarioPerfil,pageable);
    }

    @GetMapping("/{id}/pesquisar")
    public List<UsuarioResponse> pesquisarUsuario(@PathVariable Long id,@RequestParam String text,Pageable pageable){
        return pesquisarUsuarioService.pesquisarUsuario(id,text,pageable);
    }

    @GetMapping("/{id}/pesquisarAmigos")
    public List<UsuarioResponse> pesquisarAmigo(@PathVariable Long id,@RequestParam String text){
        return pesquisarUsuarioService.pesquisarAmigo(id,text);
    }

    @GetMapping("/listarAmigos/{id}")
    public List<UsuarioResponse> listarAmigos(@PathVariable Long id){
        return listarAmigosService.listar(id);
    }

    @PostMapping("/comentar")
    public void comentar(@Valid @RequestBody ComentarioRequest request){
        comentarService.comentar(request);
    }

    @GetMapping("/listarComentarios/{idPostagem}")
    public List<ComentarioResponse> listarComentarios(@PathVariable Long idPostagem){
        return listarComentariosService.listar(idPostagem);
    }

    @PostMapping("/{usuarioId}/curtir/{postagemId}")
    public void curtir(@PathVariable Long usuarioId, @PathVariable Long postagemId){
        curtidaService.curtir(usuarioId,postagemId);
    }

    @DeleteMapping("/{usuarioId}/descurtir/{postagemId}")
    public void descurtir(@PathVariable Long usuarioId, @PathVariable Long postagemId){
        curtidaService.descurtir(usuarioId,postagemId);
    }

    @PostMapping("/{idUsuario}/solicitarAmizade/{idUsuarioSolicitado}")
    public void solicitarAmizade(@PathVariable Long idUsuario, @PathVariable Long idUsuarioSolicitado){
        solicitacarAmizadeService.solicitarAmizade(idUsuario,idUsuarioSolicitado);
    }

    @PutMapping("/{idUsuario}/aceitarAmizade/{idUsuarioSolicitante}")
    public void aceitarAmizade(@PathVariable Long idUsuario, @PathVariable Long idUsuarioSolicitante){
        aceitarAmizadeService.aceitarAmizade(idUsuario,idUsuarioSolicitante);
    }

    @DeleteMapping("/{idUsuario}/desfazerAmizade/{idAmigo}")
    public void desfazerAmizade(@PathVariable Long idUsuario, @PathVariable Long idAmigo){
        desfazerAmizadeService.desfazerAmizade(idUsuario,idAmigo);
    }

}
