package br.com.cwi.newnoise.mapper;

import br.com.cwi.newnoise.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.newnoise.security.domain.Usuario;

public class UsuarioDetalhadoMapper {
    public static UsuarioDetalhadoResponse toResponse(Usuario usuario) {
        return UsuarioDetalhadoResponse.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .imagemPerfil(usuario.getImagemPerfil())
                .dataNascimento(usuario.getDataNascimento())
                .build();
    }
}
