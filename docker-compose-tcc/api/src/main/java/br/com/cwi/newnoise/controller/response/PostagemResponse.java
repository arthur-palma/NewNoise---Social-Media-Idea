package br.com.cwi.newnoise.controller.response;


import br.com.cwi.newnoise.domain.TipoVisibilidade;
import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostagemResponse {

    private Long id;

    private UsuarioResponse usuario;

    private String texto;

    private TipoVisibilidade visibilidade;

    private LocalDateTime dataPostagem;

    private List<ComentarioResponse> comentarios;

    private List<CurtidaResponse> curtidas;

    private int totalComentarios;

    private int totalCurtidas;
}
