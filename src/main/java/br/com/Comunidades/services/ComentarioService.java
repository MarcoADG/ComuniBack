package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Comentario;
import br.com.Comunidades.repositories.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	ComentarioRepository comentarioRep;
	
	public List<Comentario> listarComentarios(){
		return comentarioRep.findAll();
	}
	
	public Comentario buscarComentarioPorId(Integer comentarioId) {
		return comentarioRep.findById(comentarioId).orElseThrow(()-> new RuntimeException("Comentario não encontrado"));
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
}
