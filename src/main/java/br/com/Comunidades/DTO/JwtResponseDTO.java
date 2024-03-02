package br.com.Comunidades.DTO;

import java.util.List;

public class JwtResponseDTO {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private List<String> roles;
	private String apelido;

	public JwtResponseDTO(String accessToken, Integer id, String username, List<String> roles, String apelido) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.apelido = apelido;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
	
	public String getApelido() {
		return apelido;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
}
