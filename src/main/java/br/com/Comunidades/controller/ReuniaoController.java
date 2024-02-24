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

import br.com.Comunidades.entities.Reuniao;
import br.com.Comunidades.services.ReuniaoService;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {

	@Autowired
	ReuniaoService reuniaoServ;
	
	@GetMapping
	public ResponseEntity<List<Reuniao>> listarReuniaos() {
		return new ResponseEntity<>(reuniaoServ.listarReuniaos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarReuniaoPorId(@PathVariable Integer id) {
		Reuniao reuniao = reuniaoServ.buscarReuniaoPorId(id);
		if (reuniao != null) {
			return new ResponseEntity<>(reuniao, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Reuniao com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Reuniao> salvar(@RequestBody Reuniao reuniao) {
		return new ResponseEntity<>(reuniaoServ.novoReuniao(reuniao), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Reuniao reuniao) {
		Reuniao reuniaoAntigo = reuniaoServ.buscarReuniaoPorId(id);
		if (reuniaoAntigo != null) {
			return new ResponseEntity<>(reuniaoServ.atualizarReuniao(id, reuniao), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Reuniao com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Reuniao reuniao = reuniaoServ.buscarReuniaoPorId(id);

		if (reuniao != null) {
			reuniaoServ.deletarReuniao(id);
			return new ResponseEntity<>("Reuniao deletada com sucessa", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Reuniao com ID" + id + "não encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
