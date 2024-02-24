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

import br.com.Comunidades.entities.Comunidade;
import br.com.Comunidades.services.ComunidadeService;

@RestController
@RequestMapping("/comunidade")
public class ComunidadeController {

	@Autowired
	ComunidadeService comunidadeServ;
	
	@GetMapping
	public ResponseEntity<List<Comunidade>> listarComunidades() {
		return new ResponseEntity<>(comunidadeServ.listarComunidades(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarComunidadePorId(@PathVariable Integer id) {
		Comunidade comunidade = comunidadeServ.buscarComunidadePorId(id);
		if (comunidade != null) {
			return new ResponseEntity<>(comunidade, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Comunidade com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Comunidade> salvar(@RequestBody Comunidade comunidade) {
		return new ResponseEntity<>(comunidadeServ.novoComunidade(comunidade), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Comunidade comunidade) {
		Comunidade comunidadeAntigo = comunidadeServ.buscarComunidadePorId(id);
		if (comunidadeAntigo != null) {
			return new ResponseEntity<>(comunidadeServ.atualizarComunidade(id, comunidade), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Comunidade com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Comunidade comunidade = comunidadeServ.buscarComunidadePorId(id);

		if (comunidade != null) {
			comunidadeServ.deletarComunidade(id);
			return new ResponseEntity<>("Comunidade deletada com sucessa", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Comunidade com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
