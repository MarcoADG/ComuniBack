package br.com.Comunidades.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.Comunidades.entities.Usuario;
import br.com.Comunidades.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsuarioRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Usuario usuario = userRepository.findByEmail(username);
	    if (usuario == null) {
	        throw new UsernameNotFoundException("User Not Found with username: " + username);
	    }
	    return UserDetailsImpl.build(usuario);
	}

}
