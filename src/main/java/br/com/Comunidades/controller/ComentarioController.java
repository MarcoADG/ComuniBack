package br.com.Comunidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Comunidades.entities.Comentario;
import br.com.Comunidades.services.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	ComentarioService comentarioServ;
	
	@GetMapping
	public ResponseEntity<List<Comentario>> listarComentarios() {
		return new ResponseEntity<>(comentarioServ.listarComentarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarComentarioPorId(@PathVariable Integer id) {
		Comentario comentario = comentarioServ.buscarComentarioPorId(id);
		if (comentario != null) {
			return new ResponseEntity<>(comentario, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Comentario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario) {
		return new ResponseEntity<>(comentarioServ.novoComentario(comentario), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Comentario comentario) {
		Comentario comentarioAntigo = comentarioServ.buscarComentarioPorId(id);
		if (comentarioAntigo != null) {
			return new ResponseEntity<>(comentarioServ.atualizarComentario(id, comentario), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Comentario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Comentario comentario = comentarioServ.buscarComentarioPorId(id);

		if (comentario != null) {
			comentarioServ.deletarComentario(id);
			return new ResponseEntity<>("Comentario deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Comentario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
