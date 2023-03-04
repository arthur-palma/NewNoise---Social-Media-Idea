package br.com.cwi.newnoise.repository;

import br.com.cwi.newnoise.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
