package br.com.Comunidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Reuniao;

@Repository
public interface ReuniaoRepository extends JpaRepository<Reuniao, Integer>{

	//@Query("SELECT r FROM Reuniao r WHERE r.comunidade.comunidadeId = :comunidadeId")
    //List<Reuniao> findReunioesByComunidadeId(@Param("comunidadeId") Integer comunidadeId);
}
