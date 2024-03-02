package br.com.Comunidades.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Comunidades.DTO.JwtResponseDTO;
import br.com.Comunidades.DTO.LoginDTO;
import br.com.Comunidades.DTO.MessageResponseDTO;
import br.com.Comunidades.DTO.SignupRequestDTO;
import br.com.Comunidades.entities.CargoEnum;
import br.com.Comunidades.entities.Usuario;
import br.com.Comunidades.repositories.UsuarioRepository;
import br.com.Comunidades.security.JwtUtils;
import br.com.Comunidades.security.UserDetailsImpl;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	    String jwt = jwtUtils.generateToken(userDetails.getUsername(), userDetails.getId(), userDetails.getCargo(), userDetails.getApelido());

	    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(
	            new JwtResponseDTO(jwt, userDetails.getId(), userDetails.getUsername(), roles, userDetails.getApelido()));
	}


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequest) {

	    if (userRepository.existsByEmail(signUpRequest.getUsername())) {
	        return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
	    }

	    // Create a new user account
	    Usuario usuario = new Usuario();
	    usuario.setEmail(signUpRequest.getUsername());
	    usuario.setSenha(encoder.encode(signUpRequest.getPassword()));
	    usuario.setApelido(signUpRequest.getUsername());

	    // Assign role directly to the user entity
	    if (signUpRequest.getCargo() == null) {
	        // If no role is provided, assign a default role
	        usuario.setCargo(CargoEnum.USER); // You might want to define a default role
	    } else {
	        usuario.setCargo(CargoEnum.valueOf(signUpRequest.getCargo())); // Set the provided role
	    }

	    userRepository.save(usuario);

	    return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
	}

}
