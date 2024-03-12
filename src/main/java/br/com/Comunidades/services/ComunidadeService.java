package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.ComunidadeResponseDTO;
import br.com.Comunidades.entities.Comunidade;
import br.com.Comunidades.repositories.ComunidadeRepository;

@Service
public class ComunidadeService {

	@Autowired
	ComunidadeRepository comunidadeRep;

	public List<ComunidadeResponseDTO> listarComunidades() {
		List<Comunidade> comunidade = comunidadeRep.findAll();
		return comunidade.stream().map(this::converterParaDTO).collect(Collectors.toList());
	}

	public ComunidadeResponseDTO buscarComunidadePorId(Integer comunidadeId) {
		Comunidade comunidade = comunidadeRep.findById(comunidadeId).orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));
		return converterParaDTO(comunidade);
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

	private ComunidadeResponseDTO converterParaDTO(Comunidade comunidade) {
		return new ComunidadeResponseDTO(comunidade.getComunidadeId(), comunidade.getTema(), comunidade.getLider(),
				comunidade.getImagem(), comunidade.getEstado());
	}

}
