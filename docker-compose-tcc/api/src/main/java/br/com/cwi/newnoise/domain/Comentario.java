package br.com.cwi.newnoise.domain;

import br.com.cwi.newnoise.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Comentario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String texto;

    private LocalDateTime dataComentario;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "postagem_id", nullable = false)
    private Postagem postagem;

}
