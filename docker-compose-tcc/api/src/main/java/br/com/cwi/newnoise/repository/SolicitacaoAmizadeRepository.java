package br.com.cwi.newnoise.repository;

import br.com.cwi.newnoise.domain.SolicitacaoAmizade;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SolicitacaoAmizadeRepository extends JpaRepository<SolicitacaoAmizade,Long> {
    @Query("SELECT sa FROM SolicitacaoAmizade sa WHERE (sa.solicitante = :usuario AND sa.solicitado = :usuarioSolicitado AND sa.status = :pendente) OR (sa.solicitante = :usuarioSolicitado AND sa.solicitado = :usuario AND sa.status = :pendente)")
    Optional<SolicitacaoAmizade> findBySolicitanteAndSolicitadoOrSolicitadoAndSolicitante(@Param("usuario") Usuario usuario, @Param("usuarioSolicitado") Usuario usuarioSolicitado, @Param("pendente") String pendente);

    Optional<SolicitacaoAmizade> findBySolicitanteAndSolicitado(Usuario usuario, Usuario usuarioSolicitado);
}
