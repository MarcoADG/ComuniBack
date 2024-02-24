package br.com.Comunidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Comunidades.entities.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Integer>{

}
