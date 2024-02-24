package br.com.Comunidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Comunidade;

@Repository
public interface ComunidadeRepository extends JpaRepository<Comunidade, Integer>{

}
