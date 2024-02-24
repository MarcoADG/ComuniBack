package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.AvisoMembros;
import br.com.Comunidades.repositories.AvisoMembroRepository;

@Service
public class AvisoMembroService {

	@Autowired
	AvisoMembroRepository avisoMembroRep;

	public List<AvisoMembros> listarAvisos() {
		return avisoMembroRep.findAll();
	}

	public AvisoMembros buscarAvisoPorId(Integer avisoId) {
		return avisoMembroRep.findById(avisoId).orElseThrow(() -> new RuntimeException("Aviso não encontrado"));
	}

	public AvisoMembros novoAviso(AvisoMembros aviso) {
		return avisoMembroRep.save(aviso);
	}

	public AvisoMembros atualizarAviso(Integer id, AvisoMembros aviso) {
		return avisoMembroRep.save(aviso);
	}

	public void deletarAviso(Integer id) {
		avisoMembroRep.deleteById(id);
	}
}
