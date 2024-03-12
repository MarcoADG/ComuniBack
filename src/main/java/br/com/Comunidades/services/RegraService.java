package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.RegraResponseDTO;
import br.com.Comunidades.entities.Regra;
import br.com.Comunidades.repositories.RegraRepository;

@Service
public class RegraService {

	@Autowired
	RegraRepository regraRep;

	public List<RegraResponseDTO> listarRegras() {
		List<Regra> regra = regraRep.findAll();
		return regra.stream().map(this::converterParaDTO).collect(Collectors.toList());
	}

	public RegraResponseDTO buscarRegraPorId(Integer regraId) {
		Regra regra = regraRep.findById(regraId).orElseThrow(() -> new RuntimeException("Regra não encontrada"));
		return converterParaDTO(regra);
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

	private RegraResponseDTO converterParaDTO(Regra regra) {
		return new RegraResponseDTO(regra.getRegraId(), regra.getRegra());
	}
}
