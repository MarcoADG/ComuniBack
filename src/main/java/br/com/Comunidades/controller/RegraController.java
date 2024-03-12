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

import br.com.Comunidades.DTO.RegraResponseDTO;
import br.com.Comunidades.entities.Regra;
import br.com.Comunidades.services.RegraService;

@RestController
@RequestMapping("/regra")
public class RegraController {

	@Autowired
	RegraService regraServ;
	
	@GetMapping
	public ResponseEntity<List<RegraResponseDTO>> listarRegras() {
		return new ResponseEntity<>(regraServ.listarRegras(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarRegraPorId(@PathVariable Integer id) {
		RegraResponseDTO regra = regraServ.buscarRegraPorId(id);
		if (regra != null) {
			return new ResponseEntity<>(regra, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Regra com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Regra> salvar(@RequestBody Regra regra) {
		return new ResponseEntity<>(regraServ.novoRegra(regra), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Regra regra) {
		RegraResponseDTO regraAntigo = regraServ.buscarRegraPorId(id);
		if (regraAntigo != null) {
			return new ResponseEntity<>(regraServ.atualizarRegra(id, regra), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Regra com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		RegraResponseDTO regra = regraServ.buscarRegraPorId(id);

		if (regra != null) {
			regraServ.deletarRegra(id);
			return new ResponseEntity<>("Regra deletada com sucessa", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Regra com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
