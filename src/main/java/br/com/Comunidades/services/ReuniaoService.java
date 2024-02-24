package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Reuniao;
import br.com.Comunidades.repositories.ReuniaoRepository;

@Service
public class ReuniaoService {

	@Autowired
	ReuniaoRepository reuniaoRep;
	
	public List<Reuniao> listarReuniaos(){
		return reuniaoRep.findAll();
	}
	
	public Reuniao buscarReuniaoPorId(Integer reuniaoId) {
		return reuniaoRep.findById(reuniaoId).orElseThrow(()-> new RuntimeException("Reuniao não encontrada"));
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
}
