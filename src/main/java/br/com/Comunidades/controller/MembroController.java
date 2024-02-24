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

import br.com.Comunidades.entities.Membro;
import br.com.Comunidades.services.MembroService;

@RestController
@RequestMapping("/membro")
public class MembroController {

	@Autowired
	MembroService membroServ;
	
	@GetMapping
	public ResponseEntity<List<Membro>> listarMembros() {
		return new ResponseEntity<>(membroServ.listarMembros(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarMembroPorId(@PathVariable Integer id) {
		Membro membro = membroServ.buscarMembroPorId(id);
		if (membro != null) {
			return new ResponseEntity<>(membro, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Membro com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Membro> salvar(@RequestBody Membro membro) {
		return new ResponseEntity<>(membroServ.novoMembro(membro), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Membro membro) {
		Membro membroAntigo = membroServ.buscarMembroPorId(id);
		if (membroAntigo != null) {
			return new ResponseEntity<>(membroServ.atualizarMembro(id, membro), HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Membro com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		Membro membro = membroServ.buscarMembroPorId(id);

		if (membro != null) {
			membroServ.deletarMembro(id);
			return new ResponseEntity<>("Membro deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Membro com ID" + id + "não encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
