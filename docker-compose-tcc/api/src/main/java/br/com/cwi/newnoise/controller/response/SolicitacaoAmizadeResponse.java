package br.com.cwi.newnoise.controller.response;


import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitacaoAmizadeResponse {

    private Long id;

    private UsuarioResponse solicitante;

    private String status;
}
