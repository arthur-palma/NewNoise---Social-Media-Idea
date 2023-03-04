package br.com.cwi.newnoise.domain;

import br.com.cwi.newnoise.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Postagem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String texto;


    @Enumerated(STRING)
    private TipoVisibilidade visibilidade;

    private LocalDateTime dataPostagem;

    @OneToMany(mappedBy = "postagem")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios = new ArrayList<>();

}

