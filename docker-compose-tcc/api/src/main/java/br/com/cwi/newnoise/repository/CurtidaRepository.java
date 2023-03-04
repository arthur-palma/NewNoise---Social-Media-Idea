package br.com.cwi.newnoise.repository;

import br.com.cwi.newnoise.domain.Curtida;
import br.com.cwi.newnoise.domain.Postagem;
import br.com.cwi.newnoise.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurtidaRepository extends JpaRepository<Curtida,Long> {
    Optional<Curtida> findByUsuarioAndPostagem(Usuario usuario, Postagem postagem);
}
