package br.com.cwi.newnoise.security.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    private String apelido;

    private String imagemPerfil;
}
