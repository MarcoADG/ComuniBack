package br.com.Comunidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Integer>{

	//@Query("SELECT r FROM Aviso r WHERE r.comunidade.comunidadeId = :comunidadeId")
    //List<Aviso> findAvisosByComunidadeId(@Param("comunidadeId") Integer comunidadeId);
}
