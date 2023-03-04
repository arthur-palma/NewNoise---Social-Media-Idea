package br.com.cwi.newnoise.security.mapper;

import br.com.cwi.newnoise.security.controller.request.UsuarioRequest;
import br.com.cwi.newnoise.security.controller.response.UsuarioResponse;
import br.com.cwi.newnoise.security.domain.Usuario;

import java.util.ArrayList;

public class UsuarioMapper {

    private static final String URL_IMAGEM_PADRAO = "https://cdn-icons-png.flaticon.com/512/1661/1661004.png";

    public static Usuario toEntity(UsuarioRequest request) {
        return Usuario.builder()
                .email(request.getEmail())
                .nome(request.getNome())
                .apelido(request.getApelido())
                .imagemPerfil(request.getImagemPerfil() == null ? URL_IMAGEM_PADRAO : request.getImagemPerfil())
                .dataNascimento(request.getDataNascimento())
                .permissoes(new ArrayList<>())
                .build();

    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setImagemPerfil(entity.getImagemPerfil());
        response.setEmail(entity.getEmail());
        return response;
    }
}
