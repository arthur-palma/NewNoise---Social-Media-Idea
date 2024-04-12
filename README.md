
# NewNoise

projeto de rede social




## EndPoints sem request

- POST /login
- POST /logout
- POST /usuarios/{idUsuario}/solicitarAmizade/{idUsuarioSolicitado}
- POST /usuarios/{idUsuario}/curtir/{idPostagem}
- PUT /usuarios/{idUsuario}/aceitarAmizade/{idUsuarioSolicitante}
- DELETE /usuarios/{idUsuario}/descurtir/{idPostagem}
- DELETE /usuarios/{idUsuario}/desfazerAmizade/{idOutroUsuario}
- GET /usuarios/detalhar/{idUsuario}
- GET /usuarios/listarSolicitacoes/{idUsuario}
- GET /usuarios/listarAmigos/{idUsuario}
- GET /usuarios/listarComentarios/{idPostagem}
- GET /usuarios/listarTodasPostagens/{idUsuario}
- GET /usuarios/{idUsuario}/acessarPerfil/{idUsuarioDoPerfil}
- GET /usuarios/{idUsuario}/pesquisar?text={textoParaPesquisa}
- GET /usuarios/{idUsuario}/pesquisarAmigos?text={textoParaPesquisa}


## EndPoints com request

- POST /usuarios
request
```
     <-- apelido e imagem sao opcionais -->

{

    "nome": "Raissa Longoni Rossoni",
    "email": "raissa@gmail.com.br",
    "senha": "123456",
    "dataNascimento": "26-04-2004",
    "apelido":"Lani"
    "imagemPerfil":"url.exemplo"
}
```

- POST /publicarPostagem/{idUsuarioLogado}

request
```
    <-- tipoVisibilidade PRIVADO ou PUBLICO -->

{

    "conteudo":"exemplo de conteudo do post",
    "tipoVisibilidade":"PUBLICO"
}
```

- POST /usuarios/comentar

request
```
{
    "usuarioId":1,
    "postagemId":4,
    "texto":"exemplo comentario"
}
```
