package br.com.cwi.newnoise.domain;

import br.com.cwi.newnoise.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitacaoAmizade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(name = "solicitado_id")
    private Usuario solicitado;

    private String status;

}