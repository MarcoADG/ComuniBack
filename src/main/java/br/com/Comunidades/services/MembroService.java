package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Membro;
import br.com.Comunidades.repositories.MembroRepository;

@Service
public class MembroService {

	@Autowired
	MembroRepository membroRep;
	
	public List<Membro> listarMembros(){
		return membroRep.findAll();
	}
	
	public Membro buscarMembroPorId(Integer membroId) {
		return membroRep.findById(membroId).orElseThrow(()-> new RuntimeException("Membro não encontrado"));
	}
	
	public Membro novoMembro(Membro membro) {
		return membroRep.save(membro);
	}
	
	public Membro atualizarMembro(Integer id, Membro membro) {
		return membroRep.save(membro);
	}
	
	public void deletarMembro(Integer id) {
		membroRep.deleteById(id);
	}
}
