package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Comunidade;
import br.com.Comunidades.repositories.ComunidadeRepository;

@Service
public class ComunidadeService {

	@Autowired
	ComunidadeRepository comunidadeRep;
	
	public List<Comunidade> listarComunidades(){
		return comunidadeRep.findAll();
	}
	
	public Comunidade buscarComunidadePorId(Integer comunidadeId) {
		return comunidadeRep.findById(comunidadeId).orElseThrow(()-> new RuntimeException("Comunidade não encontrada"));
	}
	
	public Comunidade novoComunidade(Comunidade comunidade) {
		return comunidadeRep.save(comunidade);
	}
	
	public Comunidade atualizarComunidade(Integer id, Comunidade comunidade) {
		return comunidadeRep.save(comunidade);
	}
	
	public void deletarComunidade(Integer id) {
		comunidadeRep.deleteById(id);
	}
}
