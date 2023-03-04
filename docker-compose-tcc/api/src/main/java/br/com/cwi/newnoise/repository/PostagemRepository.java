package br.com.cwi.newnoise.repository;

import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.domain.TipoVisibilidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    @Query("SELECT p FROM Postagem p WHERE p.usuario.id = :usuarioId OR p.usuario.id IN (SELECT a.amigo.id FROM Amizade a WHERE (a.usuario.id = :usuarioId OR a.amigo.id = :usuarioId)) OR p.usuario.id IN (SELECT a.usuario.id FROM Amizade a WHERE (a.usuario.id = :usuarioId OR a.amigo.id = :usuarioId)) ORDER BY p.dataPostagem DESC")
    Page<Postagem> findAllByUsuarioOrAmigos(@Param("usuarioId") Long usuarioId, Pageable pageable);

    Page<Postagem> findByUsuarioIdAndVisibilidadeOrderByDataPostagemDesc(Long idUsuarioPerfil, TipoVisibilidade publico, Pageable pageable);

    Page<Postagem> findByUsuarioIdOrderByDataPostagemDesc(Long idUsuarioPerfil, Pageable pageable);
}
