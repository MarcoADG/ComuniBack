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

import br.com.Comunidades.entities.Aviso;
import br.com.Comunidades.services.AvisoService;

@RestController
@RequestMapping("/aviso")
public class AvisoController {

	@Autowired
	AvisoService avisoServ;

	@GetMapping
	public ResponseEntity<List<Aviso>> listarAvisos() {
		return new ResponseEntity<>(avisoServ.listarAvisos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarAvisoPorId(@PathVariable Integer id) {
		Aviso aviso = avisoServ.buscarAvisoPorId(id);
		if (aviso != null) {
			return new ResponseEntity<>(aviso, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("aviso com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Aviso> salvar(@RequestBody Aviso aviso) {
		return new ResponseEntity<>(avisoServ.novoAviso(aviso), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Aviso aviso) {
		Aviso avisoAntigo = avisoServ.buscarAvisoPorId(id);
		if (avisoAntigo != null) {
			return new ResponseEntity<>(avisoServ.atualizarAviso(id, aviso), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("aviso com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Aviso aviso = avisoServ.buscarAvisoPorId(id);

		if (aviso != null) {
			avisoServ.deletarAviso(id);
			return new ResponseEntity<>("aviso deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("aviso com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
