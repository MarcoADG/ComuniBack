package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Aviso;
import br.com.Comunidades.repositories.AvisoRepository;

@Service
public class AvisoService {

	@Autowired
	AvisoRepository avisoRep;
	
	public List<Aviso> listarAvisos(){
		return avisoRep.findAll();
	}
	
	public Aviso buscarAvisoPorId(Integer avisoId) {
		return avisoRep.findById(avisoId).orElseThrow(()-> new RuntimeException("Aviso não encontrado"));
	}
	
	public Aviso novoAviso(Aviso aviso) {
		return avisoRep.save(aviso);
	}
	
	public Aviso atualizarAviso(Integer id, Aviso aviso) {
		return avisoRep.save(aviso);
	}
	
	public void deletarAviso(Integer id) {
		avisoRep.deleteById(id);
	}
}
