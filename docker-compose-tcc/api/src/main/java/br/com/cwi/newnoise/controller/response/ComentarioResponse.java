package br.com.cwi.newnoise.controller.response;


import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioResponse {

    private Long id;

    private String texto;

    private LocalDateTime dataComentario;

    private UsuarioResponse usuario;

}
