package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.ReuniaoResponseDTO;
import br.com.Comunidades.entities.Reuniao;
import br.com.Comunidades.repositories.ReuniaoRepository;

@Service
public class ReuniaoService {

	@Autowired
	ReuniaoRepository reuniaoRep;
	
	public List<ReuniaoResponseDTO> listarReuniaos(){
		List<Reuniao> reuniao = reuniaoRep.findAll();
		return reuniao.stream()
				.map(this::converterParaDTO)
                .collect(Collectors.toList());
	}
	
	public ReuniaoResponseDTO buscarReuniaoPorId(Integer reuniaoId) {
		Reuniao reuniao = reuniaoRep.findById(reuniaoId).orElseThrow(()-> new RuntimeException("Reuniao não encontrada"));
		return converterParaDTO(reuniao);
	}
	
	public Reuniao novoReuniao(Reuniao reuniao) {
		return reuniaoRep.save(reuniao);
	}
	
	public Reuniao atualizarReuniao(Integer id, Reuniao reuniao) {
		return reuniaoRep.save(reuniao);
	}
	
	public void deletarReuniao(Integer id) {
		reuniaoRep.deleteById(id);
	}
	
	private ReuniaoResponseDTO converterParaDTO(Reuniao reuniao) {
        return new ReuniaoResponseDTO(
            reuniao.getReuniaoId(),
            reuniao.getDataHora(),
            reuniao.getTema(),
            reuniao.getImagem(),
            reuniao.getResponsavel(),
            reuniao.getDescricao(),
            reuniao.getMaterial(),
            reuniao.getGravacao(),
            reuniao.getResumo(),
            reuniao.getEstado());
    }
}
