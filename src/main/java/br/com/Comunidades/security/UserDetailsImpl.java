package br.com.Comunidades.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.Comunidades.entities.CargoEnum;
import br.com.Comunidades.entities.Usuario;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;
	
	private String apelido;
	
	private String cargo;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String username, String password,
	        Collection<? extends GrantedAuthority> authorities, String apelido, String cargo) {
	    this.id = id;
	    this.username = username;
	    this.password = password;
	    this.authorities = authorities;
	    this.apelido = apelido;
	    this.cargo = cargo;
	}

	public static UserDetailsImpl build(Usuario usuario) {
	    CargoEnum cargo = usuario.getCargo();
	    GrantedAuthority authority = new SimpleGrantedAuthority(cargo.name());
	    return new UserDetailsImpl(usuario.getUsuarioId(), usuario.getEmail(), usuario.getSenha(), Collections.singletonList(authority), usuario.getApelido(), cargo.name());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	
	public String getApelido() {
        return apelido;
    }
	
	
	public String getCargo() {
		return cargo;
    }

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}