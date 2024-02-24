package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Regra;
import br.com.Comunidades.repositories.RegraRepository;

@Service
public class RegraService {

	@Autowired
	RegraRepository regraRep;
	
	public List<Regra> listarRegras(){
		return regraRep.findAll();
	}
	
	public Regra buscarRegraPorId(Integer regraId) {
		return regraRep.findById(regraId).orElseThrow(()-> new RuntimeException("Regra não encontrada"));
	}
	
	public Regra novoRegra(Regra regra) {
		return regraRep.save(regra);
	}
	
	public Regra atualizarRegra(Integer id, Regra regra) {
		return regraRep.save(regra);
	}
	
	public void deletarRegra(Integer id) {
		regraRep.deleteById(id);
	}
}
