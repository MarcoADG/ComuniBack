package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.AvisoResponseDTO;
import br.com.Comunidades.entities.Aviso;
import br.com.Comunidades.repositories.AvisoRepository;

@Service
public class AvisoService {

	@Autowired
	AvisoRepository avisoRep;
	
	public List<AvisoResponseDTO> listarAvisos() {
		List<Aviso> aviso = avisoRep.findAll();
		return aviso.stream().map(this::converterParaDTO).collect(Collectors.toList());
	}

	public AvisoResponseDTO buscarAvisoPorId(Integer avisoId) {
		Aviso aviso = avisoRep.findById(avisoId).orElseThrow(() -> new RuntimeException("Aviso não encontrada"));
		return converterParaDTO(aviso);
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
	
	private AvisoResponseDTO converterParaDTO(Aviso aviso) {
		return new AvisoResponseDTO(aviso.getAvisoId(), aviso.getTitulo(), aviso.getAviso(), aviso.getDataHora(), aviso.getEstado());
	}
}
