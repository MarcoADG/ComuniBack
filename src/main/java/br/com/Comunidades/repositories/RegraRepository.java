package br.com.Comunidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Regra;

@Repository
public interface RegraRepository extends JpaRepository<Regra, Integer>{

}
