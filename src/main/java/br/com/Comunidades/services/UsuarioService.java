package br.com.Comunidades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.entities.Usuario;
import br.com.Comunidades.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRep;
	
	public List<Usuario> listarUsuarios(){
		return usuarioRep.findAll();
	}
	
	public Usuario buscarUsuarioPorId(Integer usuarioId) {
		return usuarioRep.findById(usuarioId).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
	}
	
	public Usuario novoUsuario(Usuario usuario) {
		return usuarioRep.save(usuario);
	}
	
	public Usuario atualizarUsuario(Integer id, Usuario usuario) {
		return usuarioRep.save(usuario);
	}
	
	public void deletarUsuario(Integer id) {
		usuarioRep.deleteById(id);
	}
}
