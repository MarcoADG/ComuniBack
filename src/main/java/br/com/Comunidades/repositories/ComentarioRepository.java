package br.com.Comunidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

	//@Query("SELECT r FROM Comentario r WHERE r.comunidade.comunidadeId = :comunidadeId")
    //List<Comentario> findComentariosByComunidadeId(@Param("comunidadeId") Integer comunidadeId);
}
