package br.com.Comunidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Comunidades.entities.Usuario;
import br.com.Comunidades.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioServ;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return new ResponseEntity<>(usuarioServ.listarUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
		Usuario usuario = usuarioServ.buscarUsuarioPorId(id);
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Usuario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioAntigo = usuarioServ.buscarUsuarioPorId(id);
		if (usuarioAntigo != null) {
			return new ResponseEntity<>(usuarioServ.atualizarUsuario(id, usuario), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Usuario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Usuario usuario = usuarioServ.buscarUsuarioPorId(id);

		if (usuario != null) {
			usuarioServ.deletarUsuario(id);
			return new ResponseEntity<>("Usuario deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Usuario com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
