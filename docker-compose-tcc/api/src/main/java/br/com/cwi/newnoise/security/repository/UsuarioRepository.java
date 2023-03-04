package br.com.cwi.newnoise.security.repository;

import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.id != ?1 AND (LOWER(u.nome) LIKE LOWER(CONCAT('%', ?2, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', ?2, '%')))")
    List<Usuario> findNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(Long id, String text, Pageable pageable);

    @Query("SELECT DISTINCT u FROM Usuario u JOIN Amizade a ON (u.id = a.usuario.id OR u.id = a.amigo.id) WHERE (a.usuario.id = :idUsuario OR a.amigo.id = :idUsuario) AND u.id <> :idUsuario AND (LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%')))")
    List<Usuario> findAmigosByNomeOrEmailAndUsuarioId(@Param("nome") String nome, @Param("email") String email, @Param("idUsuario") Long idUsuario);


    @Query("SELECT DISTINCT u FROM Usuario u JOIN Amizade a ON (u.id = a.usuario.id OR u.id = a.amigo.id) WHERE (a.usuario.id = :idUsuario OR a.amigo.id = :idUsuario) AND u.id <> :idUsuario")
    List<Usuario> findAllAmigosByIdUsuario(@Param("idUsuario") Long idUsuario);

}
