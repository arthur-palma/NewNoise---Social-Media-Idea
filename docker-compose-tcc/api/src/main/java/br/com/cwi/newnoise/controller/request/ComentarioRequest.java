package br.com.cwi.newnoise.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ComentarioRequest {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long postagemId;

    @NotBlank
    private String texto;

}
