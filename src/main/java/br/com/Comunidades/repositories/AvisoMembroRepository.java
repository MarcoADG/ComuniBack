package br.com.Comunidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.AvisoMembros;

@Repository
public interface AvisoMembroRepository extends JpaRepository<AvisoMembros, Integer>{

}
