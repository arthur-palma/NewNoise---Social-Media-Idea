package br.com.cwi.newnoise.controller.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurtidaResponse {

    private Long id;

    private Long usuarioId;

    private Long postagemId;

}
