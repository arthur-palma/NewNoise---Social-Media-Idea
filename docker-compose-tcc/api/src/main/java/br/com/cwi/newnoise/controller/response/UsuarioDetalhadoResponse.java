package br.com.cwi.newnoise.controller.response;

import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.domain.Permissao;
import br.com.cwi.newnoise.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDetalhadoResponse {

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private String apelido;

    private String imagemPerfil;

    private List<UsuarioResponse> amigos;

}
