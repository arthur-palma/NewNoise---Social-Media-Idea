package br.com.cwi.newnoise.security.domain;

import br.com.cwi.newnoise.domain.Amizade;
import br.com.cwi.newnoise.domain.Curtida;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private String apelido;

    private String imagemPerfil;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "solicitante")
    private List<SolicitacaoAmizade> solicitacoesEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "solicitado")
    private List<SolicitacaoAmizade> solicitacoesRecebidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Amizade> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas = new ArrayList<>();


    public void adicionarAmigo(Amizade amizade){
        amigos.add(amizade);
        amizade.setUsuario(this);
    }

    public void adicionarAmigoUsuario(Amizade amizade){
        amigos.add(amizade);
        amizade.setAmigo(this);
    }

    public void adicionarPostagem(Postagem postagem) {
        postagens.add(postagem);
        postagem.setUsuario(this);
    }

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
}
