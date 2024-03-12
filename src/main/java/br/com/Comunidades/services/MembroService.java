package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.MembroResponseDTO;
import br.com.Comunidades.entities.Membro;
import br.com.Comunidades.repositories.MembroRepository;

@Service
public class MembroService {

	@Autowired
	MembroRepository membroRep;

	public List<MembroResponseDTO> listarMembros() {
		List<Membro> membro = membroRep.findAll();
		return membro.stream().map(this::converterParaDTO).collect(Collectors.toList());
	}

	public MembroResponseDTO buscarMembroPorId(Integer membroId) {
		Membro membro = membroRep.findById(membroId).orElseThrow(() -> new RuntimeException("Membro não encontrada"));
		return converterParaDTO(membro);
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

	private MembroResponseDTO converterParaDTO(Membro membro) {
		return new MembroResponseDTO(membro.getMembroId(), membro.getNome());
	}
}
