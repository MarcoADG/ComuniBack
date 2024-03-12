package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.ComentarioResponseDTO;
import br.com.Comunidades.entities.Comentario;
import br.com.Comunidades.repositories.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	ComentarioRepository comentarioRep;
	
	public List<ComentarioResponseDTO> listarComentarios() {
		List<Comentario> comentario = comentarioRep.findAll();
		return comentario.stream().map(this::converterParaDTO).collect(Collectors.toList());
	}

	public ComentarioResponseDTO buscarComentarioPorId(Integer comentarioId) {
		Comentario comentario = comentarioRep.findById(comentarioId).orElseThrow(() -> new RuntimeException("Comentario não encontrada"));
		return converterParaDTO(comentario);
	}
	
	public Comentario novoComentario(Comentario comentario) {
		return comentarioRep.save(comentario);
	}
	
	public Comentario atualizarComentario(Integer id, Comentario comentario) {
		return comentarioRep.save(comentario);
	}
	
	public void deletarComentario(Integer id) {
		comentarioRep.deleteById(id);
	}
	
	private ComentarioResponseDTO converterParaDTO(Comentario comentario) {
		return new ComentarioResponseDTO(comentario.getComentarioId(), comentario.getComentario(), comentario.getDataHora());
	}
}
