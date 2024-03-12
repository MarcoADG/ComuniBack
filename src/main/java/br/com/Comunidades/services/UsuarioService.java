package br.com.Comunidades.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Comunidades.DTO.UsuarioResponseDTO;
import br.com.Comunidades.entities.Usuario;
import br.com.Comunidades.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRep;
	
    public List<UsuarioResponseDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioRep.findAll();
        return usuarios.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
	
    public UsuarioResponseDTO buscarUsuarioPorId(Integer usuarioId) {
        Usuario usuario = usuarioRep.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return converterParaDTO(usuario);
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
	
    private UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getUsuarioId(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getCargo(),
            usuario.getApelido());
    }
}
