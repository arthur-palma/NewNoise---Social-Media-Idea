package br.com.cwi.newnoise.controller.request;


import br.com.cwi.newnoise.domain.TipoVisibilidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PostagemRequest {
    @NotBlank
    private String conteudo;

    @NotNull
    private TipoVisibilidade tipoVisibilidade;

}
