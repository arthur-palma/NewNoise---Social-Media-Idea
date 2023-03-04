package br.com.cwi.newnoise.repository;

import br.com.cwi.newnoise.domain.Amizade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AmizadeRepository extends JpaRepository<Amizade,Long> {

    @Query("SELECT a FROM Amizade a WHERE (a.usuario.id = ?1 AND a.amigo.id = ?2) OR (a.amigo.id = ?1 AND a.usuario.id = ?2)")
    Optional<Amizade> findByUsuarioIdAndAmigoId(Long idUsuario, Long idUsuarioPerfil);

}
